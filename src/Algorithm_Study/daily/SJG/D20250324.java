package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

class D20250324 {
  static int N, M, V;
  static List<Integer>[] graph;
  static boolean[] visited;
  static boolean found;
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
        
    String[] inputNMV = br.readLine().split(" ");
        N = Integer.parseInt(inputNMV[0]);    // 정점의 개수
        M = Integer.parseInt(inputNMV[1]);    // 간선의 개수
        V = Integer.parseInt(inputNMV[2]);    // 탐색 시작 정점 번호
        
        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            
            graph[from].add(to);
            graph[to].add(from);
        }
        br.close();
        
        visited = new boolean[N+1];
        StringBuilder dfsRes = new StringBuilder();
        dfs(V, dfsRes);
        sb.append(dfsRes.toString().trim()).append("\n");
        
        visited = new boolean[N+1];
        StringBuilder bfsRes = new StringBuilder();
        bfs(V, bfsRes);
        sb.append(bfsRes.toString().trim());
        System.out.print(sb);
    }
    
    private static void dfs(int start, StringBuilder sb) {
        visited[start] = true;
        sb.append(start).append(" ");
        
        Collections.sort(graph[start]);
        
        for(int n : graph[start]) {
            if(!visited[n]) dfs(n, sb);
        }
    }
    
    private static void bfs(int start, StringBuilder sb) {
        Queue<Integer> q = new LinkedList<>();
        
        q.offer(start);
        visited[start] = true;
        sb.append(start).append(" ");
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            Collections.sort(graph[curr]);
            
            for(int n : graph[curr]) {
                if(!visited[n]) {
                    visited[n] = true;
                    q.offer(n);
                    sb.append(n).append(" ");
                }
            }
        }
    }
}
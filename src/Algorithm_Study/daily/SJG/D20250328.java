package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D20250328 {
	static int V, E;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int cnt;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        V = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());
        cnt = 0;
        
        graph = new ArrayList[V+1];
        visited = new boolean[V+1];
        for(int i = 1; i <= V; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < E; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            
            graph[from].add(to);
            graph[to].add(from);
        }
        br.close();
        
        bfs(1);
        
        System.out.print(cnt);
    }
    
    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        visited[start] = true;
        q.offer(start);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int neighbor : graph[curr]){
                if(!visited[neighbor]) {
                    visited[neighbor] = true;
                    q.offer(neighbor);
                    cnt++;
                }
            }
        }
    }
}

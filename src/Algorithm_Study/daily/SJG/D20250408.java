package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250408 {
	static int N, M;
    static List<Integer>[] graph;
    static int minSum = Integer.MAX_VALUE;
    static int minUser = -1;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNM = br.readLine().split(" ");
        N = Integer.parseInt(inputNM[0]);
        M = Integer.parseInt(inputNM[1]);
        
        graph = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            
            graph[from].add(to);
            graph[to].add(from);
        }
        
        for(int i = 1; i <= N; i++) {
            int currSum = bfs(i);
            if(currSum < minSum) {
                minSum = currSum;
                minUser = i;
            }
        }
        
        System.out.print(minUser);
    }
    
    private static int bfs(int start) {
        int totalDist = 0;
        int[] dist = new int[N+1];
        for(int i = 0; i <= N; i++) dist[i] = -1;
        
        Queue<Integer> q = new LinkedList<>();
        dist[start] = 0;
        q.offer(start);
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            
            for(int neighbor : graph[curr]) {
                if(dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;
                    q.offer(neighbor);
                }
            }
        }
        
        for(int i = 1; i <= N; i++) {
            if(i != start) totalDist += dist[i];
        }
        return totalDist;
    }
}

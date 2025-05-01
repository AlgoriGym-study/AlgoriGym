package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class D20250423 {
  static final int INF = Integer.MAX_VALUE;
    static int N, M, end;
    static List<int[]>[] adj;
    static int[] prev;
    static StringBuilder sb;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        adj = new ArrayList[N+1];
        for(int i = 1; i <= N; i++) adj[i] = new ArrayList<>();
        prev = new int[N+1];
        for(int i = 0; i <= N; i++) prev[i] = -1;
        
        // M번 순회
        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);
            int c = Integer.parseInt(input[2]);
            
            adj[s].add(new int[]{e, c});
        }
        String[] inputSE = br.readLine().split(" ");
        int start = Integer.parseInt(inputSE[0]);
        end = Integer.parseInt(inputSE[1]);
        
        dijkstraPQ(start);
        List<Integer> path = getPath(end);    // 경로
        sb.append(path.size()).append("\n");      // 경로 길이
        for (int city : path) sb.append(city).append(" ");  // 경로 출력
        System.out.print(sb);
        br.close();
    }
    
    private static void dijkstraPQ(int startNode) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1, n2) -> {
            return n1[1] - n2[1];
        });
        int[] cost = new int[N+1];
        for(int i = 1; i <= N; i++) cost[i] = INF;
        
        cost[startNode] = 0;    // 시작 노드의 비용은 0
        pq.offer(new int[]{startNode, 0});
        
        while(!pq.isEmpty()) {
            int[] curr = pq.poll();    // 현재 가장 비용이 적은 노드
            int u = curr[0];
            int cost_u = curr[1];
            
            if(cost_u > cost[u]) continue;    // 이미 더 짧은 경로를 알고 있으면 continue
            if(u == end) {
                sb.append(cost[end]).append("\n");        // 최소 비용
                break;
            }
            
            
            // 현재 노드(u)와 연결된 다른 노드들(v) 확인
            for(int[] arr : adj[u]) {
                int v = arr[0];
                int cost_uv = arr[1];
                
                // u를 거쳐 v로 가는 비용이 기존 cost[v]보다 작으면 갱신
                if(cost[v] > cost[u] + cost_uv) {
                    cost[v] = cost[u] + cost_uv;
                    prev[v] = u;
                    pq.offer(new int[]{v, cost[v]});    // 갱신된 v와 새로운 비용을 우선순위 큐에 추가
                }
            }
        }
    }
    
    private static List<Integer> getPath(int end) {
        List<Integer> list = new ArrayList<>();
        for(int i = end; i != -1; i = prev[i]) {
            list.add(i);
        }
        Collections.reverse(list);
        return list;
    }
}

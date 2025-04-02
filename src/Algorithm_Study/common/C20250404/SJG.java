package Algorithm_Study.common.C20250404;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class SJG {
  static final int INF = Integer.MAX_VALUE;
    static int N, M;
    static List<Edge>[] graph;
    static int[] dist;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputNM = br.readLine().split(" ");
        N = Integer.parseInt(inputNM[0]);
        M = Integer.parseInt(inputNM[1]);

        graph = new ArrayList[N+1];
        dist = new int[N+1];
        for(int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        for(int i = 2; i <= N; i++) dist[i] = INF;

        for(int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int A = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            int C = Integer.parseInt(input[2]);

            // 무향 그래프이기 때문에 양방향 셋팅
            graph[A].add(new Edge(B, C));
            graph[B].add(new Edge(A, C));
        }
        br.close();

        dijkstra(1);
        System.out.print(dist[N]);
    }

    private static void dijkstra(int startNode) {
        PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> {
            return e1.cost - e2.cost;
        });    // Comaparable 확장 대신 람다로 정렬 처리
        pq.offer(new Edge(startNode, 0));

        while(!pq.isEmpty()) {
            Edge curr = pq.poll();
            int currNode = curr.to;
            int currCost = curr.cost;

            
            if(currCost > dist[currNode]) continue;

            for(Edge neighbor : graph[currNode]) {
                int newDist = dist[currNode] + neighbor.cost;

                if(newDist < dist[neighbor.to]) {
                    dist[neighbor.to] = newDist;
                    pq.offer(new Edge(neighbor.to, newDist));
                }
            }
        }
    }

    static class Edge {
        int to;   // 이웃 노드 번호
        int cost;  // 가중치

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }
}

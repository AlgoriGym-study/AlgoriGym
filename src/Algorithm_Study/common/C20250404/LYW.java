package Algorithm_Study.common.C20250404;

import java.util.*;

public class LYW {
    static class Edge implements Comparable<Edge> {
        int to, cost;

        Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static List<List<Edge>> graph = new ArrayList<>();
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 헛간 개수
        int M = sc.nextInt(); // 길 개수

        // 그래프 초기화
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            graph.get(A).add(new Edge(B, C));
            graph.get(B).add(new Edge(A, C)); // 양방향
        }

        // 다익스트라 실행
        dist = new int[N + 1];
        Arrays.fill(dist, INF);
        dijkstra(1);

        // 1번 헛간에서 N번 헛간까지 최소 여물 출력
        System.out.println(dist[N]);
    }

    static void dijkstra(int start) {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();
            int current = cur.to;
            int currentCost = cur.cost;

            if (dist[current] < currentCost) continue;

            for (Edge next : graph.get(current)) {
                int newCost = dist[current] + next.cost;
                if (newCost < dist[next.to]) {
                    dist[next.to] = newCost;
                    pq.offer(new Edge(next.to, newCost));
                }
            }
        }
    }
}

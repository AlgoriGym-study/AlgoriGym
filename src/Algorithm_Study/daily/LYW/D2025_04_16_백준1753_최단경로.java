package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2025_04_16_백준1753_최단경로 {
    // 간선을 표현할 클래스 (우선순위 큐에서 사용될 비교 기준 포함)
    static class Node implements Comparable<Node> {
        int vertex; // 도착 정점
        int weight; // 가중치

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        // 가중치를 기준으로 정렬 (오름차순)
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] graph; // 인접 리스트로 그래프 표현
    static int[] dist;         // 최단 거리 배열
    static boolean[] visited;  // 방문 여부 확인

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt(); // 정점의 개수
        int E = sc.nextInt(); // 간선의 개수
        int start = sc.nextInt(); // 시작 정점

        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        visited = new boolean[V + 1];

        // 그래프와 거리 배열 초기화
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF; // 무한대로 초기화
        }

        // 간선 정보 입력
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt(); // 출발 정점
            int v = sc.nextInt(); // 도착 정점
            int w = sc.nextInt(); // 가중치
            graph[u].add(new Node(v, w));
        }

        // 다익스트라 알고리즘 실행
        dijkstra(start);

        // 결과 출력
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }

        sc.close();
    }

    // 다익스트라 알고리즘 구현
    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            if (visited[u]) continue;
            visited[u] = true;

            for (Node neighbor : graph[u]) {
                int v = neighbor.vertex;
                int w = neighbor.weight;

                // 최단 거리 갱신
                if (dist[v] > dist[u] + w) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }
    }
}

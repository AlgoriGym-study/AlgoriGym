package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.List;

class D20250402_최단경로 {
    static class Node implements Comparable<Node> {
        int s, cost;

        public Node(int s, int cost) {
            this.s = s;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E, start;
    static List<List<Node>> graph;
    static int[] dist;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        check = new boolean[V + 1];

        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        dist = new int[V + 1];
        Arrays.fill(dist, INF);

        start = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph.get(s).add(new Node(e, cost));
        }

        dist[start] = 0;
        dijkstra();

        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF)
                sb.append("INF" + "\n");
            else
                sb.append(dist[i] + "\n");
        }

        System.out.println(sb);
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, dist[start]));

        while (!pq.isEmpty()) {
            int idx = pq.poll().s;

            if (check[idx])
                continue;
            check[idx] = true;

            for (Node next : graph.get(idx)) {
                int newDist = dist[idx] + next.cost;
                if (!check[next.s] && dist[next.s] > newDist) {
                    dist[next.s] = newDist;

                    pq.add(new Node(next.s, dist[next.s]));
                }
            }
        }
    }
}
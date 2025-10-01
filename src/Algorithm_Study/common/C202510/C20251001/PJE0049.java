package Algorithm_Study.common.C202510.C20251001;
import java.util.*;

// 백준 트리의 지름
public class PJE0049 {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static class Pair {
        int node;
        long dist;
        Pair(int node, long dist) { this.node = node; this.dist = dist; }
    }

    static int V;
    static List<Edge>[] g;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        g = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) g[i] = new ArrayList<>();

        // 입력 v a d a d ... -1
        for (int i = 0; i < V; i++) {
            int v = sc.nextInt();
            while (true) {
                int a = sc.nextInt();
                if (a == -1) break;
                int d = sc.nextInt();
                // 한 줄에 해당 정점 v의 이웃이 모두 나오므로 v->a만 추가하면됨 
                g[v].add(new Edge(a, d));
            }
        }

        // 1) 임의 노드(1)에서 가장 먼 노드 A
        Pair p1 = bfs(1);
        // 2) A에서 가장 먼 거리 = 지름
        Pair p2 = bfs(p1.node);
        System.out.println(p2.dist);
    }

    // 가중치가 있는 트리에서의 BFS(큐) — 방문 시 누적거리 갱신
    static Pair bfs(int start) {
        boolean[] visited = new boolean[V + 1];
        long[] dist = new long[V + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();

        visited[start] = true;
        q.offer(start);

        int farNode = start;
        long farDist = 0L;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Edge e : g[cur]) {
                if (!visited[e.to]) {
                    visited[e.to] = true;
                    dist[e.to] = dist[cur] + e.w;
                    if (dist[e.to] > farDist) {
                        farDist = dist[e.to];
                        farNode = e.to;
                    }
                    q.offer(e.to);
                }
            }
        }
        return new Pair(farNode, farDist);
    }
}

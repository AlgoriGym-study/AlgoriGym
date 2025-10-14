package Algorithm_Study.common.C202510.C20251001;

import java.util.*;

public class LYW0049 {
    static class Edge {
        int to, w;
        Edge(int to, int w) { this.to = to; this.w = w; }
    }

    static int V;
    static ArrayList<Edge>[] g;

    public static void main(String[] args) {
        // Scanner 사용
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();

        g = new ArrayList[V + 1];
        for (int i = 1; i <= V; i++) g[i] = new ArrayList<>();

        // 입력: v a1 w1 a2 w2 ... -1
        for (int i = 0; i < V; i++) {
            int v = sc.nextInt();
            while (true) {
                int a = sc.nextInt();
                if (a == -1) break;
                int w = sc.nextInt();
                // 트리(무방향)이므로 양방향 간선 추가
                g[v].add(new Edge(a, w));
                g[a].add(new Edge(v, w));
            }
        }

        // 1) 임의의 정점(1)에서 가장 먼 정점 u 찾기
        Pair u = farthestFrom(1);

        // 2) u에서 가장 먼 거리 = 트리의 지름
        Pair ans = farthestFrom(u.node);

        System.out.println(ans.dist);
    }

    // 재귀 대신 스택으로 구현한 DFS
    static Pair farthestFrom(int start) {
        boolean[] visited = new boolean[V + 1];
        long[] dist = new long[V + 1];

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int cur = stack.pop();
            for (Edge e : g[cur]) {
                if (!visited[e.to]) {
                    visited[e.to] = true;
                    dist[e.to] = dist[cur] + e.w;
                    stack.push(e.to);
                }
            }
        }

        int farNode = start;
        long farDist = 0;
        for (int i = 1; i <= V; i++) {
            if (dist[i] > farDist) {
                farDist = dist[i];
                farNode = i;
            }
        }
        return new Pair(farNode, farDist);
    }

    static class Pair {
        int node;
        long dist;
        Pair(int node, long dist) { this.node = node; this.dist = dist; }
    }
}

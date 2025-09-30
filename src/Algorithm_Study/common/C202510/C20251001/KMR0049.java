package Algorithm_Study.common.C202510.C20251001;

import java.util.*;
import java.io.*;

public class KMR0049 {
    static int N;
    static List<Node>[] graph;
    static int maxDistance;
    static int farthestNode;
    static boolean[] visited;

    static class Node {
        int v, distance;

        public Node(int v, int distance) {
            this.v = v;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            while (st.hasMoreTokens()) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                int edge = Integer.parseInt(st.nextToken());
                graph[from].add(new Node(to, edge));
            }
        }// 입력

        maxDistance = 0;
        farthestNode = 1;
        visited = new boolean[N + 1];
        dfs(1, 0);

        maxDistance = 0;
        visited = new boolean[N + 1];
        dfs(farthestNode, 0);

        System.out.println(maxDistance);

        br.close();
    }//main

    static void dfs(int node, int distance) {
        visited[node] = true;

        if(distance > maxDistance) {
            maxDistance = distance;
            farthestNode = node;
        }

        for (Node next : graph[node]) {
            if (visited[next.v]) continue;
            dfs(next.v, distance + next.distance);
        }
    }//dfs
}

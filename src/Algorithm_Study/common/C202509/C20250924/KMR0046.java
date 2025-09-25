package Algorithm_Study.common.C202509.C20250924;

// 백준 1005번 ACM Craft

import java.util.*;
import java.io.*;

public class KMR0046 {
    static int N;
    static int[] times;
    static List<List<Integer>> graph;
    static long[] dp;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            times = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }// 걸리는 시간 입력

            graph = new ArrayList<>();
            for (int i = 0; i <= N; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(b).add(a);
            }// 규칙

            int W = Integer.parseInt(br.readLine());

            dp = new long[N + 1];
            visited = new boolean[N + 1];
            calculate(W);

            System.out.println(dp[W]);
        }// tc

        br.close();
    }//main

    static void calculate(int node) {
        if (visited[node]) return;

        visited[node] = true;
        dp[node] = times[node];
        long max = 0;

        for (int num : graph.get(node)) {
            calculate(num);
            max = Math.max(max, dp[num]);
        }
        dp[node] += max;
    }
}

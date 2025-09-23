package Algorithm_Study.daily.KMR;

import java.util.*;
import java.io.*;

public class D20250910_BOJ_15591_MooTube {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(a).add(new int[]{b, weight});
            graph.get(b).add(new int[]{a, weight});
        }// 입력

        for (int i = 0; i < Q; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{v, Integer.MAX_VALUE});

            boolean[] visited = new boolean[N + 1];
            visited[v] = true;

            int count = 0;

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                int curV = cur[0];
                int curWeight = cur[1];

                for (int[] edge : graph.get(curV)) {
                    int nextV = edge[0];
                    int edgeWeight = edge[1];

                    if (visited[nextV]) continue;

                    int pathMinWeight = Math.min(curWeight, edgeWeight);

                    // k 이상인 경로만 카운트
                    if (pathMinWeight >= k) {
                        count++;
                        queue.offer(new int[]{nextV, pathMinWeight});
                    }
                    visited[nextV] = true;
                }
            }
            System.out.println(count);
        }// 질문
        br.close();
    }
}

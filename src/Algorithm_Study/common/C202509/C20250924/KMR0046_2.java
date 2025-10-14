package Algorithm_Study.common.C202509.C20250924;

// 백준 1005 ACM Craft
import java.io.*;
import java.util.*;

public class KMR0046_2 {

    static int[] times;
    static List<Integer>[] graph;
    static boolean[] visited;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 건물의 개수
            int K = Integer.parseInt(st.nextToken()); // 건설 규칙의 총 개수

            times = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                times[i] = Integer.parseInt(st.nextToken());
            }// 건물 짓는 시간 입력

            graph = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                graph[to].add(from); // 방향 거꾸로 그래프 만들기
                // -> 목적지를 시작점으로r 변경해서 그래프 끝자락에 도달했을 때의 최댓값을 구한다.
                // -> dfs + Max값 찾기
            }// 건설 규칙 graph 입력

            int W = Integer.parseInt(br.readLine());
            visited = new boolean[N + 1];
            dp = new int[N + 1];
            build(W);

            System.out.println(dp[W]);
        }// tc
        br.close();
    }

    static void build(int from) {
        if (visited[from]) return;

        visited[from] = true;
        dp[from] = times[from];
        int max = 0;

        for (int to : graph[from]) {
            build(to);
            max = Math.max(max, dp[to]);
        }
        dp[from] += max; // from의 건설 시간 + 이후 건설하는 시간 중 최댓값(동시 건설 가능)

    }
}

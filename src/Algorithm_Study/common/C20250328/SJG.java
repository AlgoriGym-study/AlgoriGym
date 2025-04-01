package Algorithm_Study.common.C20250328;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SJG {
	static int N, M;
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] inputNM = br.readLine().split(" ");
        N = Integer.parseInt(inputNM[0]);
        M = Integer.parseInt(inputNM[1]);

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            String[] input = br.readLine().split(" ");
            int from = Integer.parseInt(input[0]);
            int to = Integer.parseInt(input[1]);
            graph[from].add(to);
        }

        int answer = 0;
        for (int i = 1; i <= N; i++) {
            int shorterCount = 0;
            for (int j = 1; j <= N; j++) {
                if (i == j) continue;
                visited = new boolean[N + 1];
                if (dfs(j, i)) {
                    shorterCount++;
                }
            }

            int tallerCount = 0;
            visited = new boolean[N + 1];
            tallerCount = countReachable(i) - 1;

            if (shorterCount + tallerCount == N - 1) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    public static boolean dfs(int start, int end) {
        visited[start] = true;
        if (start == end) {
            return true;
        }
        for (int neighbor : graph[start]) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, end)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int countReachable(int start) {
        visited[start] = true;
        int count = 1;
        for (int neighbor : graph[start]) {
            if (!visited[neighbor]) {
                count += countReachable(neighbor);
            }
        }
        return count;
    }
}

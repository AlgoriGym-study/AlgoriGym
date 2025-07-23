package Algorithm_Study.common.C202507.C20250723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class YHS0035 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> friend = new ArrayList<>();
    static ArrayList<ArrayList<Integer>> enemy = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        visited = new boolean[N+1];

        for (int i = 0; i <= N; i++) {
            friend.add(new ArrayList<>());
            enemy.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char op = st.nextToken().charAt(0);
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            if (op == 'F') {
                friend.get(from).add(to);
                friend.get(to).add(from);
            }
            else {
                enemy.get(from).add(to);
                enemy.get(to).add(from);
            }
        }

        int ans = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
                ans++;
            }
        }

        System.out.println(ans);
    }

    static void dfs(int idx) {
        for (int i : friend.get(idx)) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
        for (int i : enemy.get(idx)) {
            for (int j : enemy.get(i)) {
                if (!visited[j]) {
                    visited[j] = true;
                    dfs(j);
                }
            }
        }
    }
}

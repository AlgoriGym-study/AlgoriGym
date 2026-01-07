package Algorithm_Study.daily.YHS.before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250409_컴백홈 {
    static int R, C, K, ans;
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        ans = 0;
        dfs(R - 1, 0, 1);
        System.out.println(ans);
    }

    static void dfs(int r, int c, int count) {
        if (count > K)
            return;

        if (r == 0 && c == C - 1) {
            if (count == K) {
                ans++;
            }

            return;
        }

        visited[r][c] = true;

        if (r - 1 >= 0 && !visited[r - 1][c] && map[r - 1][c] != 'T')
            dfs(r - 1, c, count + 1);
        if (r + 1 < R && !visited[r + 1][c] && map[r + 1][c] != 'T')
            dfs(r + 1, c, count + 1);
        if (c - 1 >= 0 && !visited[r][c - 1] && map[r][c - 1] != 'T')
            dfs(r, c - 1, count + 1);
        if (c + 1 < C && !visited[r][c + 1] && map[r][c + 1] != 'T')
            dfs(r, c + 1, count + 1);

        visited[r][c] = false;
    }
}

package Algorithm_Study.common.C202509.C20250917;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SJG0044 {
    static int R, C;
    static char[][] board;
    static boolean[] visited = new boolean[26]; // 알파벳 방문 여부 (A-Z)
    static int maxCount = 0;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        // (0,0)에서 시작, 시작 칸 포함이므로 count = 1
        dfs(0, 0, 1);

        System.out.println(maxCount);
    }

    public static void dfs(int r, int c, int count) {
        visited[board[r][c] - 'A'] = true;
        maxCount = Math.max(maxCount, count);

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr >= 0 && nc >= 0 && nr < R && nc < C) {
                if (!visited[board[nr][nc] - 'A']) {
                    dfs(nr, nc, count + 1);
                }
            }
        }

        visited[board[r][c] - 'A'] = false;
    }
}

package Algorithm_Study.common.C202509.C20250917;

import java.util.Scanner;

public class LYW0044 {
    static int R, C;
    static char[][] board;
    static boolean[] visited = new boolean[26]; // 알파벳 사용 여부
    static int maxCount = 0;

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = sc.next();
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        visited[board[0][0] - 'A'] = true;
        dfs(0, 0, 1);

        System.out.println(maxCount);
    }

    static void dfs(int x, int y, int count) {
        maxCount = Math.max(maxCount, count);

        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;

            int alphaIndex = board[nx][ny] - 'A';
            if (!visited[alphaIndex]) {
                visited[alphaIndex] = true;
                dfs(nx, ny, count + 1);
                visited[alphaIndex] = false; // 백트래킹
            }
        }
    }
}

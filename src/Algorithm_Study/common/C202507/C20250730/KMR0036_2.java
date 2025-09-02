package Algorithm_Study.common.C202507.C20250730;

import java.util.Scanner;

public class KMR0036_2 {

    static int N;
    static int M;
    static int[][] map;
    static int answer;
    static int[] dr = new int[] {0, 1, 0, -1};
    static int[] dc = new int[] {1, 0, -1, 0};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        answer = 0;

        int[][] selected = new int[4][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                selected[0][0] = i;
                selected[0][1] = j;

                visited[i][j] = true;
                dfs(selected, 1);
                checkTShape(i, j);
                visited[i][j] = false;
            }
        }

        System.out.println(answer);
        sc.close();
    }

    static void dfs(int[][] selected, int count) {
        if (count == 4) {
            int sum = 0;
            for (int i = 0; i < selected.length; i++) {
                int r = selected[i][0];
                int c = selected[i][1];
                sum += map[r][c];
            }
            answer = Math.max(answer, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            if (count == 0 && d > 1) break;
            int nr = selected[count - 1][0] + dr[d];
            int nc = selected[count - 1][1] + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc]) continue;

            selected[count][0] = nr;
            selected[count][1] = nc;
            visited[nr][nc] = true;

            dfs(selected, count + 1);

            visited[nr][nc] = false;
        }
    }

    static void checkTShape(int r, int c) {
        int[][][] shapes = {
                { {0, 0}, {0, 1}, {0, -1}, {-1, 0} }, // ㅗ
                { {0, 0}, {0, 1}, {0, -1}, {1, 0} },  // ㅜ
                { {0, 0}, {-1, 0}, {1, 0}, {0, -1} }, // ㅓ
                { {0, 0}, {-1, 0}, {1, 0}, {0, 1} }   // ㅏ
        };

        for (int[][] shape : shapes) {
            boolean valid = true;
            int sum = 0;
            for (int[] offset : shape) {
                int nr = r + offset[0];
                int nc = c + offset[1];
                if (nr < 0 || nc < 0 || nr >= N || nc >= M) {
                    valid = false;
                    break;
                }
                sum += map[nr][nc];
            }
            if (valid) answer = Math.max(answer, sum);
        }
    }
}

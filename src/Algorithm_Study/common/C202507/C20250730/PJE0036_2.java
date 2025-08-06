package Algorithm_Study.common.C202507.C20250730;
import java.util.*;
// 백준 테트로미노 복습
public class PJE0036_2 {
    static int n, m;
    static int[][] arr;
    static boolean[][] visit;
    static int max = Integer.MIN_VALUE;

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];
        visit = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        // DFS로 가능한 모양 탐색
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                dfs(i, j, arr[i][j], 1);
                visit[i][j] = false;
            }
        }

        // ㅗ 모양 예외 처리
        checkExtraShapes();

        System.out.println(max);
    }

    // DFS (ㅗ 모양 제외)
    static void dfs(int row, int col, int sum, int count) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;

            if (!visit[nr][nc]) {
                visit[nr][nc] = true;
                dfs(nr, nc, sum + arr[nr][nc], count + 1);
                visit[nr][nc] = false;
            }
        }
    }

    // DFS로는 만들 수 없는 ㅗ 모양 4가지 체크
    static void checkExtraShapes() {
        // ㅗ, ㅜ, ㅏ, ㅓ 모양의 상대 좌표
        int[][][] shapes = {
            {{0,0},{0,1},{0,2},{-1,1}}, // ㅗ
            {{0,0},{0,1},{0,2},{1,1}},  // ㅜ
            {{0,0},{1,0},{2,0},{1,1}},  // ㅏ
            {{0,0},{1,0},{2,0},{1,-1}}  // ㅓ
        };

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                for (int[][] shape : shapes) {
                    int sum = 0;
                    boolean valid = true;
                    for (int[] block : shape) {
                        int nr = r + block[0];
                        int nc = c + block[1];
                        if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                            valid = false;
                            break;
                        }
                        sum += arr[nr][nc];
                    }
                    if (valid) {
                        max = Math.max(max, sum);
                    }
                }
            }
        }
    }
}

package Algorithm_Study.common.C202508.C20250806;
import java.util.*;

// 백준 테크로미노
public class PJE0036 {
    static int max = Integer.MIN_VALUE;     // 최대 합
    static int[][] arr;                     // 숫자판
    static boolean[][] visit;               // 방문 여부
    static int n, m;                        // 행, 열 크기

    // 상 하 좌 우
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

        // DFS + 백트랙
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visit[i][j] = true;
                solve(i, j, arr[i][j], 1); // 현재 위치, 누적합, 깊이1 시작
                visit[i][j] = false;
            }
        }

        System.out.println(max); // 최대합
    }

    // DFS + ㅗ자 예외 처리 포함
    static void solve(int row, int col, int sum, int count) {
        if (count == 4) {
            max = Math.max(max, sum); // 4칸 모양 완성 시 최댓값 갱신
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];

            // 범위 밖이면 건너뜀
            if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                continue;

            if (!visit[nr][nc]) {
                // 2칸째일 때 ㅗ자 모양 예외 처리
                if (count == 2) {
                    visit[nr][nc] = true;
                    solve(row, col, sum + arr[nr][nc], count + 1);
                    visit[nr][nc] = false;
                }

                visit[nr][nc] = true;
                solve(nr, nc, sum + arr[nr][nc], count + 1);
                visit[nr][nc] = false; 
            }
        }
    }
}

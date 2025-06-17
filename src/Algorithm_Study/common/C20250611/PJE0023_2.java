package Algorithm_Study.common.C20250611;
import java.util.*;
// SWEA 달팽이 숫자
public class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int[][] map = new int[N][N];

            snail(map, N);

            System.out.println("#" + tc);
            for (int[] row : map) {
                for (int val : row) {
                    System.out.print(val + " ");
                }
                System.out.println();
            }
        }
    }

    static void snail(int[][] map, int N) {
        int r = 0, c = 0, d = 0, num = 1;

        for (int i = 0; i < N * N; i++) {
            map[r][c] = num++;
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= N || map[nr][nc] != 0) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }

            r = nr;
            c = nc;
        }
    }
}



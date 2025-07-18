package Algorithm_Study.common.C202507.C20250716;

import java.util.Scanner;

public class KMR0032 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }// 입력

        int[][][] dp = new int[N][N][3];
        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if(map[i][j] == 1) continue;
                if (i == 0 && j == 1) continue;

                // 가로
                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                if(i == 0) continue;

                // 세로
                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                // 대각선
                if(!isOnMap(map, i, j - 1) || !isOnMap(map, i - 1, j)) continue;
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];

            }
        }// dp

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += dp[N - 1][N - 1][i];
        }
        System.out.println(answer);

        sc.close();
    } // main

    static boolean isOnMap(int[][]map, int r, int c) {
        if(r < 0 || c < 0 || r >= map.length || c >= map.length) return false;
        if(map[r][c] == 1) return false;
        return true;
    }
}

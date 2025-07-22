package Algorithm_Study.common.C202507.C20250716;

import java.util.*;

// 백준 17070 파이프 옮기기 1
public class PJE0032_2 {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] house = new int[N][N];
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                house[i][j] = sc.nextInt();
            }
        }
        
        int[][][] dp = new int[N][N][3]; // 0: 가로, 1: 세로, 2: 대각선
        dp[0][1][0] = 1; 

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
              
                if (house[r][c] == 1) continue; // 벽이면 건너뛰기

                // 가로
                if (c - 1 >= 0) {
                    // 가로로 도달 : 이전에 가로 또는 대각선
                    dp[r][c][0] += dp[r][c - 1][0] + dp[r][c - 1][2];
                }

                // 세로
                if (r - 1 >= 0) {
                    // 세로로 도달 : 이전에 세로 또는 대각선 
                    dp[r][c][1] += dp[r - 1][c][1] + dp[r - 1][c][2];
                }

                // 대각선
                if (r - 1 >= 0 && c - 1 >= 0) {
                    if (house[r - 1][c] == 0 && house[r][c - 1] == 0) {
                        // 대각선으로 도달 : 가로,세로,대각선 중 하나.
                        dp[r][c][2] += dp[r - 1][c - 1][0] + dp[r - 1][c - 1][1] + dp[r - 1][c - 1][2];
                    }
                }
            }
        }
        int result = dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2];
        System.out.println(result);
    }
}

package Algorithm_Study.common.C202507.C20250716;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SJG0032 {
    static int N;
    static int[][] grid;
    static int[][][] dp;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        dp = new int[N][N][3];
        
        // 입력 처리
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        // DP 초기값 설정
        dp[0][1][0] = 1;  // 시작점 (0,1)에 가로 방향으로 1가지 경우
        
        // DP 계산
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) continue;  // 벽인 경우 스킵
                
                // 가로 방향으로 이동
                if (j > 0 && grid[i][j] == 0) {
                    dp[i][j][0] += dp[i][j-1][0] + dp[i][j-1][2];
                }
                
                // 세로 방향으로 이동
                if (i > 0 && grid[i][j] == 0) {
                    dp[i][j][1] += dp[i-1][j][1] + dp[i-1][j][2];
                }
                
                // 대각선 방향으로 이동
                if (i > 0 && j > 0 && grid[i][j] == 0 && 
                    grid[i-1][j] == 0 && grid[i][j-1] == 0) {
                    dp[i][j][2] += dp[i-1][j-1][0] + dp[i-1][j-1][1] + dp[i-1][j-1][2];
                }
            }
        }
        
        int result = dp[N-1][N-1][0] + dp[N-1][N-1][1] + dp[N-1][N-1][2];
        System.out.print(result);
        br.close();
    }
}

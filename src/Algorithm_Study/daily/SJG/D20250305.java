package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20250305 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < T; tc++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            
            int[][] dp = new int[k + 1][n + 1];
            
            for(int i = 1; i <= n; i++) dp[0][i] = i;
            
            for(int i = 1; i <= k; i++) {
                for(int j = 1; j <= n; j++) {
                    if(j == 1) dp[i][j] = dp[i-1][j];
                    else dp[i][j] = dp[i][j-1] + dp[i-1][j];
                }
            }
            sb.append(dp[k][n]).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}

package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D20250320 {
	static int[][] dp;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            dp = new int[N+2][2];

            for(int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], -1);
            }
            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;
            
            fibo(N);
            sb.append(dp[N][0]).append(" ").append(dp[N][1]).append("\n");
        }
        br.close();
        System.out.print(sb);
    }

    private static int[] fibo(int n) {
        if(dp[n][0] == -1 || dp[n][1] == -1) {
            dp[n][0] = fibo(n-1)[0] + fibo(n-2)[0];
            dp[n][1] = fibo(n-1)[1] + fibo(n-2)[1];
        }
        return dp[n];
    }
}

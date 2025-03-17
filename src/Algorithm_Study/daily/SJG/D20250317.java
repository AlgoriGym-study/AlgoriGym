package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20250317 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] dp = new int[N+1 > 4 ? N+1 : 4];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;
        dp[3] = 5;
        for(int i = 4; i <= N; i++) dp[i] = (dp[i-1]+2 * dp[i-2]) % 10007;
        
        System.out.print(dp[N]);
    }
}

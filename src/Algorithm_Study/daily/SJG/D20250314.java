package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20250314 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[N+1];
        dp[0] = 1;
        for(int i = 1; i <= N; i++) dp[i] = dp[i-1] * i;
        System.out.print(dp[N]);
    }
}

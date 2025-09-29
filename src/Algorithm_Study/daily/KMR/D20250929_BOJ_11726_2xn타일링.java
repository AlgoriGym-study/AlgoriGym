package Algorithm_Study.daily.KMR;

import java.util.*;
import java.io.*;

public class D20250929_BOJ_11726_2xn타일링 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[Math.max(3, N + 1)];
        dp[1] = 1;
        dp[2] = 2;

        if (N < 3) {
            System.out.println(dp[N]);
            return;
        }

        for (int i = 3; i <= N; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[N] % 10007);

        br.close();
    }
}

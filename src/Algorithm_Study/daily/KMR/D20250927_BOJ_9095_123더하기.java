package Algorithm_Study.daily.KMR;

import java.util.*;
import java.io.*;

public class D20250927_BOJ_9095_123더하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[] dp = new int[Math.max(5, N + 1)];
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            if (N <= 3) {
                System.out.println(dp[N]);
                continue;
            }

            for (int i = 4; i < N + 1; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }

            System.out.println(dp[N]);
        }//tc

        br.close();

    }

}

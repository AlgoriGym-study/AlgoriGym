package Algorithm_Study.daily.KMR;

import java.util.*;
import java.io.*;

public class D20250924_BOJ_2939_설탕배달 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] weights = {3, 5};
        int[] dp = new int[N + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int w: weights) {
            for (int j = w; j <= N; j++) {
                if (dp[j - w] != Integer.MAX_VALUE) {
                    dp[j] = Math.min(dp[j], dp[j - w] + 1);
                }
            }
        }

        System.out.println(dp[N] == Integer.MAX_VALUE ? -1 : dp[N]);

        br.close();
    }
}

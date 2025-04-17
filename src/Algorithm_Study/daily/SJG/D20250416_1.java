package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250416_1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] score = new int[N+1];
        int[] dp = new int[N+1];
        for(int i = 1; i <= N; i++) score[i] = Integer.parseInt(br.readLine());
        dp[1] = score[1];
        if(N > 1) dp[2] = score[1] + score[2];
        // 두칸 점프했을때, -3계단을 밟고, 이전계단과 현재 계단을 밟을때(연속된 세칸의 계단을 밟을 수 없기 때문)
        for(int i = 3; i <= N; i++) {
            dp[i] = Math.max(dp[i-2] + score[i], dp[i-3] + score[i-1] + score[i]);
        }
        
        System.out.print(dp[N]);
        br.close();
    }
}

package Algorithm_Study.daily.PJE;

import java.util.Scanner;
// SWEA knapsack
public class D20250414 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			for (int tc = 1; tc <= T; tc++) {
				
				int N = sc.nextInt(); // 물건 개수 
				int K = sc.nextInt(); // 부피 합
				
				int [] vol = new int [N+1];
				int [] val = new int [K+1];
				for (int i = 1; i <= N; i++) {
					vol[i] = sc.nextInt(); // 부피
					val[i] = sc.nextInt(); // 가치
				}
				int [][] dp = new int [N+1][K+1];
				//물건번호
				for (int i = 1; i <= N; i++) {
					//임시부피
					for (int j = 0; j <= K; j++) {
						
						if(vol[i] <=j) {
							dp[i][j] = Math.max( dp[i-1][j], dp[i-1][j-vol[i]]+val[i]);
						}else {
							dp[i][j] = dp[i-1][j];
						}
						
						
					}
				}
				 System.out.println("#"+tc+" "+dp[N][K]);			}
		}
}
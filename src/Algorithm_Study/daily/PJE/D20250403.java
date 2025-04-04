package Algorithm_Study.daily.PJE;
import java.util.Arrays;
import java.util.Scanner;
// SWEA 수영장 문제
public class D20250403 {
	static int INF = Integer.MAX_VALUE;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int [] fee = new int[5]; // 가격들
			int [] plan = new int [13]; // 이용계획
			int [] dp = new int [13]; // dp
			Arrays.fill(dp, INF); // 최대값으로 채워놓음 
			dp[0]=0;  // 시작은 0
			
			// [10,40,100,300] 
			for (int i = 1; i < 5 ; i++) {
				fee[i] = sc.nextInt();
			}
			
			// [0 0 2 9 1 5 0 0 0 0 0 0] 
			for (int i = 1; i <= 12; i++) {
				plan[i] = sc.nextInt();
			}
			// 1~12월
			for (int i = 1; i < 13; i++) {
				// 1일, 한달, 3달 권과 비교
				dp[i] = Math.min(dp[i], dp[i-1]+plan[i]*fee[1]);
				dp[i] = Math.min(dp[i], dp[i-1]+fee[2]);
				if(i+2 <= 12) {// 11,12,1,2월은 구매 못함
					dp[i+2] = Math.min(dp[i+2], dp[i-1]+fee[3]);
				}
			}
			int answer = Math.min(dp[12], fee[4]); 
			System.out.println("#"+tc+" "+answer);
		}
	}
}

package Algorithm_Study.daily.PJE;

import java.util.Scanner;
// SWEA 장훈이의 높은 선반
public class D20250417 {
	static int N,B,ans;
	static int [] H;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); // 점원 수 
			B = sc.nextInt(); // 탑의 높이 
			H = new int [N]; // 점원 키
			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt(); 
			}
			//부분집합 
			ans = Integer.MAX_VALUE;
			recur(0,0);
			System.out.println("#"+tc+" "+ans);
		}
	}

	private static void recur(int idx, int hsum) {
		if(idx == N) {
			if(hsum >= B) {
				ans = Math.min(ans, hsum-B);
			}
			
			return;
		}
		
		
		recur(idx+1,hsum);
		recur(idx+1,hsum+H[idx]);
	}
}


package Algorithm_Study.daily.PJE;

import java.util.Scanner;
//swea 부분 수열의 합 
public class D20250310 {
	static int [] nums;
	static int N,K;
	static boolean [] sel;
	static int sum,ans;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //몇개의 자연수 ? 
			K = sc.nextInt(); //합해서 얼마가 되야하는지
			
			nums = new int [N];
			sel = new boolean [N];
			for (int i = 0; i < nums.length; i++) {
				nums[i] = sc.nextInt();
			}
			sum = ans = 0;
			 recur(0,0);
			System.out.println("#"+tc+" "+ans);
			
		}
	}
	
	static void recur(int idx,int sum) {
		
		if(idx == N) {
				if(sum == K) {
					ans++;
				}
			
			return;
		}
		
		
		recur(idx+1,sum);
		
		recur(idx+1,sum+nums[idx]);
		
		
	}
}

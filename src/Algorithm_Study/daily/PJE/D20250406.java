package _0406;
import java.util.Scanner;

public class  D20250406{
	static int N,B,sum,ans;
	static int [] H;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			B = sc.nextInt();
			H = new int[N];

			sum = 0;
			for (int i = 0; i < N; i++) {
				H[i] = sc.nextInt();
				sum += H[i];
			}
			
			ans = Integer.MAX_VALUE;
			recur(0,0);
			System.out.println("#"+tc+" "+ans);
		}
	}
	
	static void recur(int idx,int hsum) {
		
		if(idx == N) { 
			if(hsum >= B) {
				ans = Math.min(ans, hsum-B);
			}
			return;
		}
		
		recur(idx+1, hsum); 
		recur(idx+1, hsum+H[idx]); 
	}
}






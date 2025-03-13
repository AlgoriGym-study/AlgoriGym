package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_03_13_SWEA_거듭제곱 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;
		for(int tc = 1; tc <= T; tc++) {
			int t = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int answer = func(N, M);
			System.out.println("#" + tc + " " + answer);
			
		}//tc
	}
	
	static int func(int N, int M) {
		// 종료 조건
		if(M == 1) {
			return N;
		}
		
		// 재귀 부분
		return N * func(N, M-1);
	}
}

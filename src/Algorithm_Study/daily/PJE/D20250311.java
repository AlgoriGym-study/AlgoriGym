package Algorithm_Study.daily.PJE;

import java.util.Scanner;
//햄버거 다이어트
public class D20250311 {
	static int N,K,answer;
	static int [] score,cal;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt(); //재료수
			K = sc.nextInt(); //제한칼로리
			
			score = new int [N]; //점수
			cal = new int [N];  //칼로리
			
			for (int i = 0; i < N; i++) {
				score[i] = sc.nextInt();
				cal[i] = sc.nextInt();
			}
			
			answer = 0;
			recur(0,0,0);
			System.out.println("#"+tc+" "+answer);
			
		}
	}
	
	static void recur(int idx, int sSum, int calSum) { //인덱스, 점수 합, 칼로리 합
		
		if(idx==N) {
			if(calSum <= K) {
				answer = Math.max(sSum, answer);
			}
			return;
		}
		
		recur (idx+1, sSum+score[idx], calSum+cal[idx]);
		recur (idx+1, sSum, calSum);
		
		
	}
	
}

package Algorithm_Study.daily.PJE;

import java.util.Scanner;
// SWEA 최빈수 구하기
public class D20250427 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int num = sc.nextInt();
			int [] count = new int [101];
			for (int i = 0; i < 1000; i++) {
				int score = sc.nextInt(); //점수
				count[score]++;
			}
			int max = -1;
			int answer = 0;
			for (int i = 0; i < 101; i++) {
				if(max <= count[i]) {
					max = count[i];
					answer = i;
				}
			}
			System.out.println("#"+num+" "+answer);
		}
	}
}

package Algorithm_Study.daily.PJE;

import java.util.Scanner;
//SWEA 요리사
public class D20250305 {
	static int[][] S;
	static int answer;

	static void comb(int idx, int sidx, int[] tidxarr,boolean[] selected, int N) {
		if (sidx == N / 2) { // 다뽑음
			cal(tidxarr,selected, N);
			return;
		}
		if (idx == N) {
			return;
		}
		
		tidxarr[sidx] = idx;
		
		selected[idx] =true; //A요리
		comb(idx + 1, sidx + 1, tidxarr,selected, N);
		selected[idx] =false;
		comb(idx + 1, sidx, tidxarr,selected, N);
	}

	private static void cal(int[] tidxarr, boolean[] selected, int N) { // 0,1,2면 나머지 3,4,5을 여기에서 찾아야?
		int sum = 0;
		int oSum = 0;
		int[] other = new int[tidxarr.length]; // 나머지 인덱스를 찾아야하는것

		// B 요리 인덱스 찾기
		int oIdx = 0;

		for (int i = 0; i < N; i++) {
			if (!selected[i]) { // A 요리에 포함되지 않은 것 == B 요리
				other[oIdx++] = i;
			}
		}
		// A요리 시너지
		for (int i = 0; i < tidxarr.length; i++) {
			for (int j = i + 1; j < tidxarr.length; j++) {
				int a = other[i];
				int b = other[j];
				oSum += S[a][b] + S[b][a];
			}
		}
		// B요리 시너지
		for (int i = 0; i < tidxarr.length; i++) {
			for (int j = i + 1; j < tidxarr.length; j++) {
				int a = tidxarr[i];
				int b = tidxarr[j];
				sum += S[a][b] + S[b][a];
			}
		}

		answer = Math.min(answer, Math.abs(oSum - sum));

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int TC = sc.nextInt();
		for (int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt(); // N개의 식재료
			
			S = new int[N][N];
			answer = Integer.MAX_VALUE;
			
			for (int i = 0; i < S.length; i++) {
				for (int j = 0; j < S.length; j++) {
					S[i][j] = sc.nextInt();
				}
			}
			// 입력

			int[] tidxarr = new int[N / 2]; // 임시 인덱스배열
			boolean[] selected = new boolean[N]; // A요리 B요리 구분용 방문 배열
			comb(0, 0, tidxarr,selected, N); 

			System.out.println("#" + tc + " " + answer);
		}
	}
}

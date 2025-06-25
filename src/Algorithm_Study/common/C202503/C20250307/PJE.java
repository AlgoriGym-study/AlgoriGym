package Algorithm_Study.common.C202503.C20250307;

import java.util.Scanner;

public class PJE {
//야구팀 구성. 가장 많은 인원의 팀 구성하기 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {

			int N = sc.nextInt(); // N명의 야구선수.
			int K = sc.nextInt(); // K 실력차이
			// 가장 많이 구성할 수 있는 팀의 인원수를구하라.
			// 숫자 하나에 대해서 1. +K 2. -K하고 그 안에 들어있는 숫자들의 갯수를 세야함.
			// 가장 큰 숫자를 출력.
			
			int[] team = new int[N];
			for (int i = 0; i < N; i++) {
				team[i] = sc.nextInt();
			}
			// 입력
			
			int maxCnt = Integer.MIN_VALUE;

			for (int i = 0; i < N; i++) {
				int cnt = 0, cnt2 = 0;
				int skill = team[i];
				int maxSkill = skill + K; // 최대
				int minSkill = skill - K; // 최소
				
				if (minSkill < 0) 
					continue;

				for (int j = 0; j < N; j++) {
					if ( skill <= team[j] && team[j] <= maxSkill )
						cnt++;
					if ( minSkill <= team[j] && team[j] <= skill )
						cnt2++;
				}

				maxCnt = Math.max(maxCnt, cnt);
				maxCnt = Math.max(maxCnt, cnt2);

			}
			int answer = maxCnt;
			System.out.println("#" + tc + " " + answer);
		}
	}
}

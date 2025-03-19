package Algorithm_Study.common.C20250311;

import java.util.Arrays;
import java.util.Scanner;

public class PJE {
//swea 나무 높이
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		int T = sc.nextInt(); // 테스트 케이스 개수
		for (int tc = 1; tc <= T; tc++) {
			sb.append("#").append(tc).append(" ");

			int N = sc.nextInt(); // 나무 개수
			int[] tree = new int[N];
			int sum = 0; // 총합
			int tallest = 0; // 가장 큰 나무

			for (int i = 0; i < N; i++) {
				tree[i] = sc.nextInt();
			}

			// 최대높이 찾기
			for (int i = 0; i < N; i++) {
				if (tallest < tree[i])
					tallest = tree[i];
			}

			// 나무의 높이를 보정하고 총 합 구하기
			for (int i = 0; i < N; i++) {
				tree[i] = tallest - tree[i];
				sum += tree[i];
			}
			// 모든 나무가 최대높이면 총합이 0. 다음 케이스로 넘어감
			if (sum == 0) {
				sb.append(0).append("\n");
				continue;
			}

			// 나무 높이 정렬
			Arrays.sort(tree);
			int day = 1;

			// 최소 날짜 계산
			while (true) {
				for (int i = 0; i < N; i++) {
					if (tree[i] >= 3) {
						if (day % 2 == 1) { // 홀수 날
							tree[i] -= 1;
						} else { // 짝수 날
							tree[i] -= 2;
						}
						break;
					}
					if (day % 2 == 1 && tree[i] == 1) { // 홀수 날: 1 제거
						tree[i] = 0;
						break;
					}
					if (day % 2 == 0 && tree[i] == 2) { // 짝수 날: 2 제거
						tree[i] = 0;
						break;
					}
				}

				// 모든 나무가 0이면 종료
				if (check(tree))
					break;
				day++;
			}

			sb.append(day).append("\n");
		}

		System.out.println(sb);
	}

	// 모든 나무가 0인지 확인하는 함수
	private static boolean check(int[] tree) {
		for (int height : tree) {
			if (height != 0)
				return false;
		}
		return true;
	}
}

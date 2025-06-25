package Algorithm_Study.common.C202503.C20250311;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class LYW {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[] arr = new int[N];

			// 나무 높이 배열에 입력값 넣기
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			// 높이 순서로 정렬
			Arrays.sort(arr);
			int max = arr[N - 1]; // 최대 나무 높이

			// 최대값을 제외한 나무 높이 배열을 리스트로 변환
			List<Integer> list = new ArrayList<>();
			for (int i = 0; i < N; i++) {
				if (arr[i] < max) {
					list.add(arr[i]);
				}
			}

			int size = list.size();
			int date = 0; // 날짜 변수 (홀짝 판별)

			// 모든 나무의 높이가 같다면 0일
			if (list.isEmpty()) {
				date = 0;
			} else {
				// 1. max-2 이상 max 보다 작을 때까지, 홀수날에는 +1, 짝수날에는 +2
				for (int i = 0; i < size; i++) {
					while (true) {
						date++;
						// 홀수날 -> +1
						if (date % 2 != 0) {
							list.set(i, list.get(i) + 1);
						}
						// 짝수날 -> +2
						else {
							list.set(i, list.get(i) + 2);
						}
						// 탈출 조건
						if (list.get(i) < max && list.get(i) >= max - 2) {
							break;
						}
					}
				}

				// 2. 홀수날에는 홀수 값 삭제, 짝수날에는 짝수 값 삭제
				while (true) {
					date++;
					boolean ok = false; // 예외 판별용 변수

					// 홀수날인 경우 (홀수 값 삭제)
					if (date % 2 != 0) {
						for (int a = list.size() - 1; a >= 0; a--) { // 역순으로 순회하여 삭제
							if (list.get(a) % 2 != 0) {
								list.remove(a);
								ok = true;
							}
						}
						// 3. 예외) 홀수날인데 리스트에 홀수가 없을 경우
						if (ok == false) {
							for (int a = 0; a < list.size(); a++) {
								if (list.get(a) < max) {
									list.set(a, list.get(a) + 1);
									break;
								}
							}
						}
					}
					// 짝수날인 경우 (짝수 값 삭제)
					else {
						for (int a = list.size() - 1; a >= 0; a--) { // 역순으로 순회하여 삭제
							if (list.get(a) % 2 == 0) {
								list.remove(a);
								ok = true;
							}
						}
						// 3. 예외) 짝수날인데 리스트에 짝수가 없을 경우
						if (ok == false) {
							// 물 주기 패스
						}
					}

					// 탈출 조건: 리스트가 비어 있는 경우 모든 나무 높이가 max와 동일해짐
					if (list.isEmpty()) {
						break;
					}
				}
			}
			System.out.println("#" + test_case + " " + date);
		}
		sc.close(); // Scanner 닫기 (리소스 해제)
	}
}

package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_05_06_SWEA_회문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {
			int tc = sc.nextInt();
			char[][] arr = new char[100][100];

			for (int i = 0; i < 100; i++) {
				String line = sc.next();
				for (int j = 0; j < 100; j++) {
					arr[i][j] = line.charAt(j);
				}
			}

			int maxLen = 0;

			// 가로 탐색
			for (int i = 0; i < 100; i++) {
				for (int len = 100; len >= 1; len--) {
					for (int j = 0; j <= 100 - len; j++) {
						if (isPalindromeRow(arr, i, j, len)) {
							maxLen = Math.max(maxLen, len);
							break; // 더 긴 회문은 없으므로 다음 줄로
						}
					}
					if (maxLen == len)
						break; // 이미 최대 길이 발견
				}
			}

			// 세로 탐색
			for (int j = 0; j < 100; j++) {
				for (int len = 100; len >= 1; len--) {
					for (int i = 0; i <= 100 - len; i++) {
						if (isPalindromeCol(arr, i, j, len)) {
							maxLen = Math.max(maxLen, len);
							break;
						}
					}
					if (maxLen == len)
						break;
				}
			}

			System.out.println("#" + tc + " " + maxLen);
		}
	}

	// 가로 회문 확인
	static boolean isPalindromeRow(char[][] arr, int row, int start, int len) {
		for (int k = 0; k < len / 2; k++) {
			if (arr[row][start + k] != arr[row][start + len - 1 - k]) {
				return false;
			}
		}
		return true;
	}

	// 세로 회문 확인
	static boolean isPalindromeCol(char[][] arr, int start, int col, int len) {
		for (int k = 0; k < len / 2; k++) {
			if (arr[start + k][col] != arr[start + len - 1 - k][col]) {
				return false;
			}
		}
		return true;
	}
}

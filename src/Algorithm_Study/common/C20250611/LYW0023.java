package Algorithm_Study.common.C20250611;

import java.util.Arrays;
import java.util.Scanner;

public class LYW0023 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			int K = N;
			int r = 0;
			int c = -1;
			int dir = 1;
			int num = 1;

			while (true) {
				// 1. 가로로 K칸 이동 (오른쪽 또는 왼쪽)
				for (int i = 0; i < K; i++) {
					c += dir;
					arr[r][c] = num++;
				}
				K--; // 가로 이동 후, 다음 이동은 한 칸 줄어듦
				if (K == 0)
					break;

				// 2. 세로로 K칸 이동 (아래 또는 위)
				for (int i = 0; i < K; i++) {
					r += dir;
					arr[r][c] = num++;
				}
				dir = -dir; // 방향 전환
			}

			System.out.println("#" + test_case);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}

		}
	}

}

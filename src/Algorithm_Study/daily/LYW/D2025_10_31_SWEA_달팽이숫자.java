package Algorithm_Study.daily.LYW;

import java.util.Scanner;
import java.io.FileInputStream;

public class D2025_10_31_SWEA_달팽이숫자 {
	public static void main(String args[]) throws Exception {

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
				for (int i = 0; i < K; i++) {
					c += dir;
					arr[r][c] = num;
					num++;
				}
				K--;
				if (K == 0)
					break;

				for (int i = 0; i < K; i++) {
					r += dir;
					arr[r][c] = num;
					num++;
				}
				dir = -dir;
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
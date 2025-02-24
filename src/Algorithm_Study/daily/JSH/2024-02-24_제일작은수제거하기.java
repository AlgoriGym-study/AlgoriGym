import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

class Solution {
	public static void main(String args[]) throws Exception {

		// Scanner sc = new Scanner(System.in);
		Scanner sc = new Scanner(new File("input.txt"));
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt(); // N 입력
			int M = sc.nextInt(); // M 입력

			int[] arrN = new int[N];
			int[] arrM = new int[M];

			for (int i = 0; i < N; i++) {
				arrN[i] = sc.nextInt();
			}
			for (int i = 0; i < M; i++) {
				arrM[i] = sc.nextInt();
			}

			int max = Integer.MIN_VALUE;
			if (N < M) {
				for (int i = 0; i < M - N + 1; i++) {
					int sum = 0;
					for (int j = 0; j < N; j++) {
						sum += arrN[j] * arrM[j + i];
					}
					max = Math.max(max, sum);

				}
			} else {
				for (int i = 0; i < N - M + 1; i++) {
					int sum = 0;
					for (int j = 0; j < M; j++) {
						sum += arrM[j] * arrN[j + i];
					}
					max = Math.max(max, sum);
				}

			}

			System.out.println("#" + test_case + " " + max);
		}
	}
}
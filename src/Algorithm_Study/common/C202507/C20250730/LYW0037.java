package Algorithm_Study.common.C202507.C20250730;

import java.util.*;

public class LYW0037 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		// 집중국 수가 센서 수 이상이면, 각 센서에 설치 가능 → 최소 거리 합 = 0
		if (K >= N) {
			System.out.println(0);
			return;
		}

		int[] sensors = new int[N];
		for (int i = 0; i < N; i++) {
			sensors[i] = sc.nextInt();
		}

		Arrays.sort(sensors);

		Integer[] diff = new Integer[N - 1];
		for (int i = 0; i < N - 1; i++) {
			diff[i] = sensors[i + 1] - sensors[i];
		}

		Arrays.sort(diff);

		int ans = 0;
		for (int i = 0; i < N - K; i++) {
			ans += diff[i];
		}

		System.out.println(ans);

	}

}

package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

class D20250321_N과M_5 {
	static int[] nums;
	static List<Integer> ans;
	static int N, M;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		nums = new int[N];
		ans = new ArrayList<>();

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			nums[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(nums);

		sb = new StringBuilder();
		perm(0);
		System.out.println(sb);
	}

	static void perm(int depth) {
		if (depth == M) {
			for (int num : ans) {
				sb.append(num + " ");
			}
			sb.append("\n");

			return;
		}

		for (int i = 0; i < N; i++) {
			if (!ans.contains(nums[i])) {
				ans.add(depth, nums[i]);
				perm(depth + 1);
				ans.remove(depth);
			}
		}
	}
}

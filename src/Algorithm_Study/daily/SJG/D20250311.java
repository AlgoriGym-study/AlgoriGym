package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20250311 {
	static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        br.close();
        int[] res = new int[M];
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = i + 1;
        perm(0, arr, M, res, N);

        System.out.print(sb);
    }

    private static void perm(int idx, int[] arr, int M, int[] res, int N) {
        if (idx == M) {
            for (int n : res) sb.append(n).append(" ");
            sb.append("\n");
            return;
        }
        for (int i = 0; i < N; i++) {
            res[idx] = arr[i];
            perm(idx + 1, arr, M, res, N);
        }
    }
}

package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250320_N과M_4 {
    static int N, M;
    static int[] nums;
    static int[] ans;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        ans = new int[M];

        sb = new StringBuilder();
        perm(0, 1);
        System.out.println(sb);
    }

    static void perm(int depth, int start) {
        if (depth == M) {
            for (int num : ans) {
                sb.append(num + " ");
            }
            sb.append("\n");

            return;
        }

        for (int i = start; i <= N; i++) {
            ans[depth] = i;
            perm(depth + 1, i);
        }
    }
}

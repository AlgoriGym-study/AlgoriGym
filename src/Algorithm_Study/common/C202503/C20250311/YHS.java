package Algorithm_Study.common.C202503.C20250311;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class YHS {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine());

            int max = Integer.MIN_VALUE; // 가장 큰 나무의 높이
            int[] trees = new int[N];
            for (int i = 0; i < N; i++) {
                trees[i] = Integer.parseInt(st.nextToken());

                max = Math.max(max, trees[i]);
            }

            // 나무가 자라야 할 높이에서 필요한 1, 2의 개수 구하기
            int even = 0, odd = 0;
            for (int i = 0; i < N; i++) {
                int diff = max - trees[i];

                if (diff == 0)
                    continue;

                even += diff / 2; // 2를 기준으로 계산
                odd += diff % 2;
            }

            // 2 -> 1로 변경
            if (even > odd) {
                while (Math.abs(even - odd) > 1) {
                    even--;
                    odd += 2; // 2는 1을 두번 더한것이므로
                }
            }

            int result = 0;
            if (odd > even)
                result = odd * 2 - 1;
            else if (even > odd)
                result = even * 2;
            else
                result = even + odd;

            System.out.printf("#%d %d\n", tc, result);
        }
    }
}
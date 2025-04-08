package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250325_숫자만들기 {
    static int N, max, min;
    static int[] nums, op, usedOp;
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            op = new int[4];
            nums = new int[N];
            usedOp = new int[N - 1];

            /*
             * op[0] = '+'
             * op[1] = '-'
             * op[2] = '*'
             * op[3] = '/'
             */

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            max = -100000000;
            min = 100000000;
            dfs(0);

            System.out.printf("#%d %d\n", tc, max - min);
        }
    }

    static void dfs(int depth) {
        if (depth == N - 1) {
            calculate();
        }

        for (int i = 0; i < 4; i++) {
            if (op[i] == 0)
                continue;

            op[i]--;
            usedOp[depth] = i;
            dfs(depth + 1);
            op[i]++;
        }
    }

    static void calculate() {
        int num = nums[0];
        for (int i = 0; i < N - 1; i++) {
            switch (usedOp[i]) {
                case 0:
                    num += nums[i + 1];
                    break;
                case 1:
                    num -= nums[i + 1];
                    break;
                case 2:
                    num *= nums[i + 1];
                    break;
                case 3:
                    num /= nums[i + 1];
                    break;
            }
        }

        max = Math.max(max, num);
        min = Math.min(min, num);
    }

}
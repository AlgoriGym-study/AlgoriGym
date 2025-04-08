package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D20250319_RGB_색상_조합 {
    static int[] RGB;
    static int S, count;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            S = Integer.parseInt(br.readLine());
            RGB = new int[3];
            sb = new StringBuilder();
            count = 0;

            comb(0, 0, 0);
            if (count == 0)
                System.out.println(-1);
            else {
                System.out.println(count);
                System.out.println(sb);
            }
        }
    }

    static void comb(int idx, int sum, int start) {
        if (sum > S)
            return;

        if (idx == 3) {
            if (sum == S) {
                count++;
                for (int color : RGB) {
                    sb.append(color + " ");
                }
                sb.append("\n");
            }

            return;
        }

        for (int i = start; i <= 10; i++) {
            RGB[idx] = i;
            comb(idx + 1, sum + i, 0);
        }
    }
}

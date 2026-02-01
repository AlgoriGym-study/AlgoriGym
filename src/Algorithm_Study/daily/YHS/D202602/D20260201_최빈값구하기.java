package Algorithm_Study.daily.YHS.D202602;

import java.io.*;
import java.util.*;

public class D20260201_최빈값구하기 {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int tc = Integer.parseInt(br.readLine());
            int[] scores = new int[101];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 1000; i++) {
                scores[Integer.parseInt(st.nextToken())]++;
            }

            int max = Integer.MIN_VALUE;
            int ans = 0;

            for (int i = 0; i < scores.length; i++) {
                max = Math.max(max, scores[i]);
                if (scores[i] == max) ans = i;
            }

            System.out.printf("#%d %d\n", tc, ans);
        }
    }
}

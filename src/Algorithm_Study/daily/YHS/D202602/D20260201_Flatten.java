package Algorithm_Study.daily.YHS.D202602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D20260201_Flatten {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int dump = Integer.parseInt(br.readLine());
            int[] box = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 100; i++) {
                box[i] = Integer.parseInt(st.nextToken());
            }

            while (dump > 0) {
                Arrays.sort(box);
                if (box[99]-box[0] <= 1) break;
                box[99]--;
                box[0]++;
                dump--;
            }
            Arrays.sort(box);
            System.out.printf("#%d %d\n", tc, box[99]-box[0]);
        }
    }
}

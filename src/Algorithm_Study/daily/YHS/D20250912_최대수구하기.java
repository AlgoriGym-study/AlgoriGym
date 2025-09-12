package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250912_최대수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int max = Integer.MIN_VALUE;
            int[] arr = new int[10];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                if (arr[i] > max) max = arr[i];
            }

            System.out.println("#" + tc + " " + max);
        }
    }
}

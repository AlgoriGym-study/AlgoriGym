package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D20250912_중간평균값구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= t; tc++) {
            int[] arr = new int[10];
            int sum = 0;
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 10; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(arr);

            for (int j = 1; j < 9; j++) {
                sum += arr[j];
            }

            System.out.println("#" + tc + " " + Math.round(sum / 8.0));
        }
    }
}

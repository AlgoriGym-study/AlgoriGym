package Algorithm_Study.common.C202507.C20250730;

import java.util.Arrays;
import java.util.Scanner;

public class KMR0037 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        if (K >= N) {
            System.out.println(0);
            return;
        }


        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int[] diff = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diff[i] = arr[i + 1] - arr[i];
        }

        Arrays.sort(diff);

        int sum = 0;
        for (int i = 0; i < N - K; i++) {
            sum += diff[i];
        }

        System.out.println(sum);


        sc.close();
    }
}

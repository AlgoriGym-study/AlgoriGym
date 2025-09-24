package Algorithm_Study.common.C202509.C20250917;

import java.util.*;
import java.io.*;

public class LYW0045_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] a = new long[N];
        for (int i = 0; i < N; i++) a[i] = sc.nextLong();

        Arrays.sort(a);

        long ans;
        if (N == 1) {
            ans = a[0];
        } else if (N == 2) {
            ans = Math.max(a[0], a[1] - a[0]);
        } else {
            long maxGap = a[0];
            for (int i = 2; i < N; i++) {
                long gap = a[i] - a[i - 2];
                if (gap > maxGap) maxGap = gap;
            }
            ans = maxGap;
        }

        System.out.println(ans);
    }
}

package Algorithm_Study.common.C202509.C20250917;

import java.io.*;
import java.util.*;

public class KMR0045_2 {
    static long[] times;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        times = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Long.parseLong(st.nextToken());
        }

        long left = 1;
        long right = 1_000_000_000 + 1;
        long answer = Long.MAX_VALUE;

        while (left < right) {
            long mid = (left / 2) + (right / 2);
            if (canSolve(mid)) {
                right = mid;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
        br.close();
    }//main

    static boolean canSolve(long gap){
        long boxes = 0L;
        for (int i = 0; i < times.length; i++) {
            boxes += (times[i] + gap - 1) / gap;
        }

        if (2L * times.length > boxes) return true;
        return false;
    }
}

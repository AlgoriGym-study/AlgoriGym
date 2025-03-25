package Algorithm_Study.daily.CSY;

import java.util.Arrays;
import java.util.Scanner;

public class D20250324_N과M2 {

    static int N, M;
    static boolean[] sel;
    static int[] result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sel = new boolean[M];
        result = new int[M];

        cur(0, 0);
    }

    static void cur(int idx, int sidx) {
        if(sidx == M) {
            for(int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }else if(idx == N) {
            return;
        }else {
            result[sidx] = idx + 1;
            cur(idx+1, sidx+1);
            cur(idx+1, sidx);

        }

    }

}

package Algorithm_Study.daily.CSY.March;

import java.util.Arrays;
import java.util.Scanner;
public class D20250328_N과M6 {

        static int N, M;
        static int[] arr;
        static boolean[] visited;
        static int[] result;

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            N = sc.nextInt();
            M = sc.nextInt();

            arr = new int[N];
            visited = new boolean[N];
            result = new int[M];

            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);

            comb(0, 0);
        }

        static void comb(int idx, int sidx) {
            if(sidx == M) {
                for(int r : result) {
                    System.out.print(r + " ");
                }
                System.out.println();
                return;
            }else {
                for(int i = idx; i <= N - M + sidx; i++) {
                    result[sidx] = arr[i];
                    comb(i + 1, sidx + 1);
                }
            }

        }



}

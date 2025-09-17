package Algorithm_Study.daily.KMR;

import java.util.*;
import java.io.*;

public class D20250917_SWEA_Flatten {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 100;
        int T = 10;

        for (int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine()); // 덤프 횟수
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] array = new int[100];
            for (int i = 0; i < 100; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }// 입력

            int[] counted = new int[101];
            for (int i = 0; i < array.length; i++) {
                counted[array[i]]++;
            }// 빈도 배열

            int minIdx = 0, maxIdx = 0;
            for (int i = 0; i < counted.length; i++) {
                if (counted[i] != 0) {
                    minIdx = i;
                    break;
                }
            }

            for (int i = 100; i >= 0; i--) {
                if (counted[i] != 0) {
                    maxIdx = i;
                    break;
                }
            }

            while (K > 0) {
                if (maxIdx <= minIdx) break;
                int value = Math.min(counted[maxIdx], counted[minIdx]);
                value = Math.min(value, K);
                counted[minIdx] -= value;
                counted[maxIdx] -= value;
                counted[minIdx + 1] += value;
                counted[maxIdx - 1] += value;

                K -= value;

                if (counted[maxIdx] == 0) maxIdx--;
                if (counted[minIdx] == 0) minIdx++;
            }

            int answer = maxIdx - minIdx;
            System.out.printf("#%d %d\n", tc, answer);
        }//tc

        br.close();
    }// main
}

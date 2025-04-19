package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_04_17_SWEA_장훈이의_높은선반 {

    static int N, B, minDiff;
    static int[] hightArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();  // 직원 수
            B = sc.nextInt();  // 선반 높이

            hightArr = new int[N];
            for (int i = 0; i < N; i++) {
                hightArr[i] = sc.nextInt(); // 직원 키 입력
            }

            minDiff = Integer.MAX_VALUE;

            subset(0, 0); // 부분집합 시작

            System.out.println("#" + tc + " " + minDiff);
        }
    }

    // 부분집합을 만들어보는 재귀함수
    static void subset(int idx, int sum) {
        if (idx == N) {
            if (sum >= B) {
                minDiff = Math.min(minDiff, sum - B);
            }
            return;
        }

        // 현재 직원 포함
        subset(idx + 1, sum + hightArr[idx]);

        // 현재 직원 미포함
        subset(idx + 1, sum);
    }
}

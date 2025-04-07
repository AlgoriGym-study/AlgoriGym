package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_04_07_SWEA_햄스터 {
    static int N, X, M;
    static int[][] sentence;
    static int[] ham;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            X = sc.nextInt();
            M = sc.nextInt();
 
            sentence = new int[M][3];
 
            for (int i = 0; i < M; i++) {
                // l
                sentence[i][0] = sc.nextInt() - 1;
                // r
                sentence[i][1] = sc.nextInt() - 1;
                // s
                sentence[i][2] = sc.nextInt();
            }
 
            ham = new int[N];
            ham[N - 1] = -1;
 
            int maxHamSum = -1;
            int[] answer = new int[N];
 
            while (up()) {
                if (check()) {
                    int hamSum = 0;
                    for (int i = 0; i < ham.length; i++) {
                        hamSum += ham[i];
                    }
                    if (maxHamSum < hamSum) {
                        maxHamSum = hamSum;
                        for (int i = 0; i < ham.length; i++) {
                            answer[i] = ham[i];
                        }
                    }
                }
            }
 
            System.out.print("#" + tc + " ");
 
            if (maxHamSum == -1) {
                // maxHamSum이 -1이면 모든 조건을 만족시키는 배치가 없다
                System.out.print(-1);
            } else {
                for (int i = 0; i < ham.length; i++) {
                    System.out.print(answer[i] + " ");
                }
            }
            System.out.println();
        }
    }
 
    // 마지막 우리에 햄스터 한마리 추가
    static boolean up() {
        // 마지막 우리의 index는 N - 1
        int i = N - 1;
        ham[i]++;
 
        // 각 우리에는 X마리까지만 들어갈 수 있는데
        // 초과하면 왼쪽 우리를 올림 해줘야함, 현재 우리는 0마리로 되돌아감
        while (ham[i] == X + 1) {
            if (i == 0)
                return false;
            ham[i] = 0; // 현재 우리 0
            ham[--i]++; // 왼쪽 우리 증가
        }
        return true;
    }
 
    // 현재 배치된 햄스터가 조건을 만족하는지 검사
    static boolean check() {
        for (int i = 0; i < M; i++) {
            int l = sentence[i][0];
            int r = sentence[i][1];
            int sum = sentence[i][2];
            int hamSum = 0;
            for (int j = l; j <= r; j++) {
                hamSum += ham[j];
            }
            if (hamSum != sum)
                return false;
        }
        return true;
    }
 
}
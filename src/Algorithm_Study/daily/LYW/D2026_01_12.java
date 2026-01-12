package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2026_01_12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rounds = sc.nextInt(); // 라운드 수

        for (int i = 0; i < rounds; i++) {
            int[] a = new int[5]; // A 플레이어의 도형 개수 (인덱스 1~4 사용)
            int[] b = new int[5]; // B 플레이어의 도형 개수 (인덱스 1~4 사용)

            int aCount = sc.nextInt();
            for (int j = 0; j < aCount; j++) {
                int shape = sc.nextInt();
                a[shape]++;
            }

            int bCount = sc.nextInt();
            for (int j = 0; j < bCount; j++) {
                int shape = sc.nextInt();
                b[shape]++;
            }

            // 도형 우선순위: 4 > 3 > 2 > 1
            char result = 'D'; // 기본값 무승부
            for (int shape = 4; shape >= 1; shape--) {
                if (a[shape] > b[shape]) {
                    result = 'A';
                    break;
                } else if (a[shape] < b[shape]) {
                    result = 'B';
                    break;
                }
            }
            System.out.println(result);
        }

        sc.close();
    }
}
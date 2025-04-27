package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_04_25_백준10163_색종이 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] paper = new int[101][101];  // 도화지 100x100

        for (int n = 1; n <= N; n++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int w = sc.nextInt();
            int h = sc.nextInt();

            // 색종이 붙이기 (번호로 채우기)
            for (int i = x; i < x + w; i++) {
                for (int j = y; j < y + h; j++) {
                    paper[i][j] = n;
                }
            }
        }

        // 각 색종이 별 넓이 계산
        for (int n = 1; n <= N; n++) {
            int count = 0;
            for (int i = 0; i <= 100; i++) {
                for (int j = 0; j <= 100; j++) {
                    if (paper[i][j] == n) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

        sc.close();
    }
}

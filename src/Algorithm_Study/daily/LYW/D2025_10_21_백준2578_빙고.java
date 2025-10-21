package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_10_21_백준2578_빙고 {
    static int[][] board = new int[5][5];
    static boolean[][] marked = new boolean[5][5];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 빙고판 입력
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        // 사회자가 부르는 숫자 처리
        for (int turn = 0; turn < 25; turn++) {
            int number = sc.nextInt();
            markNumber(number);

            if (countBingo() >= 3) {
                System.out.println(turn + 1);
                break;
            }
        }
        sc.close();
    }

    // 숫자에 해당하는 칸을 true로 표시
    static void markNumber(int num) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (board[i][j] == num) {
                    marked[i][j] = true;
                    return;
                }
            }
        }
    }

    // 빙고 라인 개수 세기
    static int countBingo() {
        int count = 0;

        // 가로줄 확인
        for (int i = 0; i < 5; i++) {
            boolean bingo = true;
            for (int j = 0; j < 5; j++) {
                if (!marked[i][j]) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) count++;
        }

        // 세로줄 확인
        for (int j = 0; j < 5; j++) {
            boolean bingo = true;
            for (int i = 0; i < 5; i++) {
                if (!marked[i][j]) {
                    bingo = false;
                    break;
                }
            }
            if (bingo) count++;
        }

        // 대각선 1 확인
        boolean diag1 = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][i]) {
                diag1 = false;
                break;
            }
        }
        if (diag1) count++;

        // 대각선 2 확인
        boolean diag2 = true;
        for (int i = 0; i < 5; i++) {
            if (!marked[i][4 - i]) {
                diag2 = false;
                break;
            }
        }
        if (diag2) count++;

        return count;
    }
}

package Algorithm_Study.daily.YHS.before;

import java.io.*;

public class D20250421_빙고1 {
    static int[][] bingo;
    static int count;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bingo = new int[5][5];
        count = 0;

        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(input[j]);
            }
        }

        int callCount = 0;
        for (int i = 0; i < 5; i++) {
            String[] calledNumbers = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                callCount++;
                int num = Integer.parseInt(calledNumbers[j]);

                for (int x = 0; x < 5; x++) {
                    for (int y = 0; y < 5; y++) {
                        if (bingo[x][y] == num) {
                            bingo[x][y] = 0;
                        }
                    }
                }

                rCheck();
                cCheck();
                lrCheck();
                rlCheck();

                if (count >= 3) {
                    System.out.println(callCount);
                    return;
                }
                count = 0;
            }
        }
    }

    // 가로 체크
    public static void rCheck() {
        for (int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[i][j] == 0)
                    zeroCount++;
            }
            if (zeroCount == 5)
                count++;
        }
    }

    // 세로 체크
    public static void cCheck() {
        for (int i = 0; i < 5; i++) {
            int zeroCount = 0;
            for (int j = 0; j < 5; j++) {
                if (bingo[j][i] == 0)
                    zeroCount++;
            }
            if (zeroCount == 5)
                count++;
        }
    }

    // 왼쪽에서 오른쪽으로 그어지는 대각선 체크
    public static void lrCheck() {
        int zeroCount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][i] == 0)
                zeroCount++;
        }
        if (zeroCount == 5)
            count++;
    }

    // 오른쪽에서 왼쪽으로 그어지는 대각선 체크
    public static void rlCheck() {
        int zeroCount = 0;
        for (int i = 0; i < 5; i++) {
            if (bingo[i][4 - i] == 0)
                zeroCount++;
        }
        if (zeroCount == 5)
            count++;
    }
}
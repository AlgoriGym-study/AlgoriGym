package Algorithm_Study.daily.YHS.D202602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20260201_Sum {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int T = Integer.parseInt(br.readLine());
            int[][] map = new int[100][100];

            for (int i = 0; i < 100; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int max = Integer.MIN_VALUE;
            int leftDiagonal = 0;
            int rightDiagonal = 0;
            for (int i = 0; i < 100; i++) {
                int rowSum = 0;
                int colSum = 0;
                for (int j = 0; j < 100; j++) {
                    colSum += map[j][i];
                    rowSum += map[i][j];
                }

                max = Math.max(max, Math.max(rowSum, colSum));

                rightDiagonal += map[i][i];
                leftDiagonal += map[i][100-i-1];
            }

            max = Math.max(max, Math.max(leftDiagonal, rightDiagonal));

            System.out.printf("#%d %d\n", T, max);
        }
    }
}

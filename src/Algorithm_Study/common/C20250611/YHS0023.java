package Algorithm_Study.common.C20250611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class YHS0023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] snail = new int[N][N];

            int K = N;
            int row = 0;
            int col = -1;
            int dir = 1;
            int num = 1;
            while (true) {
                for (int i = 0; i < K; i++) {
                    col += dir;
                    snail[row][col] = num++;
                }
                K--;

                if (K == 0)
                    break;

                for (int i = 0; i < K; i++) {
                    row += dir;
                    snail[row][col] = num++;
                }
                dir *= -1;
            }

            System.out.println("#" + tc);
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(snail[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}

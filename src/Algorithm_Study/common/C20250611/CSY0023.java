package Algorithm_Study.common.C20250611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CSY0023 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().split(" ")[0]);
        for(int tc = 1; tc <= T; tc++){

        int N = Integer.parseInt(br.readLine().split(" ")[0]);

        int k = N; // 점점 줄어드는 N의 값
        int c = -1; // 열
        int r = 0; // 행
        int n = 1; // 보드에 찍을 숫자
        int d = 1; // 진행 방향

        int[][] board = new int[N][N];

        while(k > 0){
            // k까지 c+d;
            for(int i = 0; i < k; i++){
                c += d;
                board[r][c] = n++;
            }
            k--; // c가 k면 k-1

            // k까지 r+d;
            for(int i = 0; i < k; i++){
                r += d;
                board[r][c] = n++;
            }
            d = -d; // r=k면, d=-d
        }


        // 출력
            System.out.println("#"+tc);
        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
        }
    }
}

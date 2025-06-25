package Algorithm_Study.common.C202506.C20250611;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CSY0023_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().split(" ")[0]);
        int k = N; // 점점 줄어드는 N의 값
        int c = -1; // 열의 좌표
        int r = 0; // 행의 좌표
        int n = 1; // 출력할 숫자
        int d = 1; // 진행 방향

        int[][] board = new int[N][N];

        while(k > 0){ // k가 0이 되면 종료
            int i = 0;
            while(i < k){
                c += d;
                board[r][c] = n++;
                i++;
            }
            k--;
            i = 0;
            while(i < k){
                r += d;
                board[r][c] = n++;
                i++;
            }
            d = -d; // 방향 전환
        }

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
}

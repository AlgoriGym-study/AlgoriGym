package Algorithm_Study.daily.CSY.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250417_색종이 {


    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().split(" ")[0]); // 색종이 수
        boolean[][] board = new boolean[100][100]; // 도화지 크기
        // 색종이 크기 10 * 10 이고, 종이밖으로 나가지 않기 때문에 r, c 좌표는 최대 90이다.

        for(int n = 0; n < N; n++) {
            StringTokenizer st =  new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            for(int i = 0; i < 10; i++) {
                for(int j = 0; j < 10; j++) {
                    if(board[r+i][c+j]) continue;
                    board[r+i][c+j] = true;
                }
            }

        }

        int ans = 0;
        for(int i = 0; i < board.length; i++) {
            for(boolean a : board[i]) {
                if(a) ans++;
            }
        }

        System.out.println(ans);
    }

}


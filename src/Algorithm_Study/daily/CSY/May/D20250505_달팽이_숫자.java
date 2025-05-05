package Algorithm_Study.daily.CSY.May;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D20250505_달팽이_숫자 {

    static int dir, k, num, r, c;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine().split(" ")[0]);
        StringBuilder sb = new StringBuilder();
        for(int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append("\n");

            int N = Integer.parseInt(br.readLine().split(" ")[0]);

            int[][] arr = new int[N][N];
            r = 0;
            c = -1;
            num = 1;
            k = N;
            dir = 1;

            while(k > 0) {
                // 열
                for(int i = 0; i< k; i++) {
                    c += dir;
                    arr[r][c] = num++;
                }
                k--;
                // 행
                for(int i = 0; i < k; i++) {
                    r += dir;
                    arr[r][c] = num++;
                }
                dir = -dir;
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }

        }
        System.out.println(sb.toString());
    }

}

package Algorithm_Study.common.C202507.C20250716;

import java.io.*;
import java.nio.file.NotLinkException;
import java.util.*;

public class KMR0032_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(br.readLine());
            }
        }

        int[][][] dp = new int[N][N][3];
        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(map[i][j] == 1) continue;
                if(i == 0 && j == 1) continue;

                dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];

                if(i == 0) continue;

                dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];

                if(!isOnMap(map, i, j - 1) || !isOnMap(map, i - 1, j)) continue;
                dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];

            }
        }// dp

        int answer = 0;
        for (int i = 0; i < 3; i++) {
            answer += dp[N - 1][N - 1][i];
        }
        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isOnMap(int[][]map, int r, int c) {
        if(r < 0 || c < 0 || r >= map.length || c >= map.length) return false;
        if(map[r][c] == 1) return false;
        return true;
    }
}

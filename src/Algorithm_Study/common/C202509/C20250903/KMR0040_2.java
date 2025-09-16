package Algorithm_Study.common.C202509.C20250903;

import java.io.*;
import java.util.*;

// 백준 아기상어 복습
public class KMR0040_2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int R = -1;
        int C = -1;

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 9) {
                    R = i;
                    C = j;
                }
            }
        }// 입력







        br.close();

    }
}

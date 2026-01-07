package Algorithm_Study.daily.YHS.before;

import java.io.*;
import java.util.*;

public class D20250408_알파벳 {
    static int R, C, max;
    static char[][] board;
    static Set<Character> set = new HashSet<>();
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        max = Integer.MIN_VALUE;

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            board[i] = br.readLine().toCharArray();
        }

        set.add(board[0][0]);
        dfs(0, 0, 1);
        System.out.println(max);
    }

    static void dfs(int r, int c, int count) {
       max = Math.max(max, count);

       for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C) continue;

            if (set.contains(board[nr][nc])) continue;

            set.add(board[nr][nc]);
            dfs(nr,nc,count+1);
            set.remove(board[nr][nc]);
       }
    }
}

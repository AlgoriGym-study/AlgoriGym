package Algorithm_Study.daily.LYW;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class D2025_03_30_SWEA_파핑파핑_지뢰찾기 {
 
    static int N;
    static char[][] board;
    static int[][] count;
    static int[] dr = { 0, 1, 1, 1, 0, -1, -1, -1 };
    static int[] dc = { 1, 1, 0, -1, -1, -1, 0, 1 };
 
    static boolean inBoard(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
 
            board = new char[N][];
            count = new int[N][N];
 
            for (int r = 0; r < N; r++) {
                board[r] = sc.next().toCharArray();
                for (int c = 0; c < N; c++) {
                    if (board[r][c] == '*') {
                        for (int d = 0; d < 8; d++) {
                            int nr = r + dr[d];
                            int nc = c + dc[d];
                            if (inBoard(nr, nc)) {
                                count[nr][nc]++;
                            }
                        }
                    }
                }
            }
 
            int click = 0;
 
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (board[r][c] == '*')
                        continue;
                    if (count[r][c] == 0) {
                        click++;
                        Queue<int[]> queue = new LinkedList<>();
                        queue.add(new int[] { r, c });
                        board[r][c] = '*';
 
                        while (!queue.isEmpty()) {
                            int rr = queue.peek()[0];
                            int cc = queue.peek()[1];
                            queue.poll();
 
                            for (int d = 0; d < 8; d++) {
                                int nr = rr + dr[d];
                                int nc = cc + dc[d];
                                if (inBoard(nr, nc) && board[nr][nc] != '*') {
                                    board[nr][nc] = '*';
                                    if (count[nr][nc] == 0) {
                                        queue.add(new int[] { nr, nc });
                                    }
                                }
                            }
                        }
                    }
                }
            }
 
            for (int r = 0; r < N; r++) {
                for (int c = 0; c < N; c++) {
                    if (board[r][c] != '*')
                        click++;
                }
            }
 
            System.out.println("#" + tc + " " + click);
        }
    }
 
}
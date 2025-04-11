package Algorithm_Study.common.C20250411;

import java.util.*;
import java.io.*;

public class YHS {
    static int N;
    static int[][] board;
    static boolean[][] visited;
    static List<Matrix> ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            visited = new boolean[N][N];
            ans = new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && board[i][j] != 0) {
                        notBFS(i, j);
                    }
                }
            }

            Collections.sort(ans);
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(tc).append(" ").append(ans.size()).append(" ");
            for (Matrix m : ans) {
                sb.append(m.row).append(" ").append(m.col).append(" ");
            }
            System.out.println(sb);
        }
    }

    static void notBFS(int r, int c) {
        int row = 0, col = 0;
        int i = r, j = c;

        // 세로 길이 찾기
        while (i < N && board[i][c] != 0) {
            i++;
            row++;
        }

        // 가로 길이 찾기
        while (j < N && board[r][j] != 0) {
            j++;
            col++;
        }

        // 방문 처리
        for (int x = r; x < r + row; x++) {
            for (int y = c; y < c + col; y++) {
                visited[x][y] = true;
            }
        }

        ans.add(new Matrix(row, col));
    }

    static class Matrix implements Comparable<Matrix> {
        int row, col;

        Matrix(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Matrix o) {
            int area1 = this.row * this.col;
            int area2 = o.row * o.col;
            if (area1 != area2)
                return area1 - area2;
            return this.row - o.row;
        }
    }
}

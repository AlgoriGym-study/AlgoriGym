package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class D20250423_치즈 {
    static int N, M, hour, count;
    static int[][] board;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] == 1)
                    count++;
            }
        }

        bfs();
    }

    static void bfs() {
        Queue<coor> q = new LinkedList<>();
        q.add(new coor(0, 0));
        visited = new boolean[N][M];
        visited[0][0] = true;

        int melted = 0;
        hour++;

        while (!q.isEmpty()) {
            coor c = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = c.x + dr[d];
                int nc = c.y + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M)
                    continue;

                if (visited[nr][nc])
                    continue;

                visited[nr][nc] = true;

                if (board[nr][nc] == 0)
                    q.add(new coor(nr, nc));
                else if (board[nr][nc] == 1) {
                    melted++;
                    board[nr][nc] = 0;
                }
            }
        }

        count -= melted;

        if (count == 0) {
            System.out.println(hour);
            System.out.println(melted);
            return;
        } else {
            bfs();
        }
    }

    static class coor {
        int x, y;

        public coor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

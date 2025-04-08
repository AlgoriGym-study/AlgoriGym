package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D20250330_미로탐색 {

    static class Pos {
        int x, y, dist;

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int N, M;
    static int[][] maze;
    static boolean[][] visit;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new int[N][M];
        visit = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
            }
        }

        int ans = bfs(0, 0);
        System.out.println(ans);
    }

    static int bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(new Pos(x, y, 1));

        while (!q.isEmpty()) {
            Pos curr = q.poll();
            int row = curr.x;
            int col = curr.y;
            int dist = curr.dist;

            if (row == N - 1 && col == M - 1)
                return dist;

            for (int d = 0; d < 4; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < M) {
                    if (maze[nr][nc] == 1 && !visit[nr][nc]) {
                        visit[nr][nc] = true;
                        q.add(new Pos(nr, nc, dist + 1));
                    }
                }
            }
        }

        return -1;
    }
}

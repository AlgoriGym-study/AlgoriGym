package Algorithm_Study.daily.YHS.before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D20250331_나이트의이동 {

    static class Pos {
        int x, y, dist;

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int L, count, min;
    static int endX, endY;
    static int[][] chess;
    static boolean[][] visited;
    static int[] dr = { -1, -2, -2, -1, 1, 2, 2, 1 };
    static int[] dc = { -2, -1, 1, 2, 2, 1, -1, -2 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            L = Integer.parseInt(br.readLine());
            chess = new int[L][L];
            visited = new boolean[L][L];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            endX = Integer.parseInt(st.nextToken());
            endY = Integer.parseInt(st.nextToken());

            min = Integer.MAX_VALUE;
            int ans = bfs(startX, startY);
            System.out.printf("%d\n", ans);
        }

    }

    static int bfs(int x, int y) {
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(x, y, 0));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Pos curr = q.poll();
            int row = curr.x;
            int col = curr.y;

            if (row == endX && col == endY)
                return curr.dist;

            for (int d = 0; d < 8; d++) {
                int nr = row + dr[d];
                int nc = col + dc[d];

                if (nr >= 0 && nr < L && nc >= 0 && nc < L) {
                    if (!visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.add(new Pos(nr, nc, curr.dist + 1));
                    }
                }
            }
        }

        return -1;
    }
}

package Algorithm_Study.daily.YHS;

import java.util.LinkedList;
import java.util.Queue;

public class D20250427_게임맵최단거리 {
    static int[] dr = {-1,1,0,0};
    static int[] dc = {0,0,-1,1};

    public int solution(int[][] maps) {
        int r = maps.length;
        int c = maps[0].length;

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0,0,1));
        boolean[][] visited = new boolean[r][c];
        visited[0][0] = true;

        while (!q.isEmpty()) {
            Pos curr = q.poll();

            if (curr.x == r-1 && curr.y == c-1) {
                return curr.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr.x + dr[d];
                int nc = curr.y + dc[d];

                if (nr < 0 || nr >= r || nc < 0 || nc >= c) continue;

                if (visited[nr][nc] || maps[nr][nc] == 0) continue;

                visited[nr][nc] = true;

                q.add(new Pos(nr,nc,curr.dist+1));

            }
        }

        return -1;
    }

    static class Pos {
        int x, y, dist;

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}

package Algorithm_Study.common.C202504.C20250429;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class YHS {
    static final int INF = Integer.MAX_VALUE;
    static int N;
    static int[][] map;
    static int[][] dist;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = INF;
                }
            }

            System.out.printf("#%d %d\n", tc, dijkstra());
        }
    }

    static int dijkstra() {
        PriorityQueue<Pos> pq = new PriorityQueue<>();
        dist[0][0] = 0;
        pq.offer(new Pos(0, 0, 0));

        while (!pq.isEmpty()) {
            Pos curr = pq.poll();

            if (curr.x == N - 1 && curr.y == N - 1) {
                return curr.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nr = curr.x + dr[d];
                int nc = curr.y + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                int moveCost = 0;
                if (map[nr][nc] < map[curr.x][curr.y]) {
                    moveCost = 0;
                } else if (map[nr][nc] == map[curr.x][curr.y]) {
                    moveCost = 1;
                } else {
                    moveCost = 2 * Math.abs(map[nr][nc] - map[curr.x][curr.y]);
                }

                if (dist[nr][nc] > curr.dist + moveCost) {
                    dist[nr][nc] = curr.dist + moveCost;
                    pq.offer(new Pos(nr, nc, dist[nr][nc]));
                }
            }
        }

        return dist[N-1][N-1];
    }


    static class Pos implements Comparable<Pos> {
        int x, y, dist;

        public Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }

        @Override
        public int compareTo(Pos o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}

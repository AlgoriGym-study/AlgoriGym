package Algorithm_Study.common.202509.20250903;
import java.util.*;

//백준 녹색 옷 입은애가 젤다지?
public class PJE0041 {
    static int N;
    static int[][] map;
    static int[][] dist;
    static final int INF = Integer.MAX_VALUE;
    static final int[] dr = {-1, 1, 0, 0};
    static final int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r, c, cost;
        Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;

        while (true) {
            N = sc.nextInt();
            if (N == 0) break;

            map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    map[i][j] = sc.nextInt();
                    dist[i][j] = INF;
                }
            }

            dijkstra();

            System.out.println("Problem " + (tc++) + ": " + dist[N-1][N-1]);
        }
        sc.close();
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[0][0] = map[0][0];
        pq.add(new Node(0, 0, map[0][0]));

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int r = cur.r;
            int c = cur.c;
            int cost = cur.cost;

            if (cost > dist[r][c]) continue;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;

                int newCost = cost + map[nr][nc];
                if (newCost < dist[nr][nc]) {
                    dist[nr][nc] = newCost;
                    pq.add(new Node(nr, nc, newCost));
                }
            }
        }
    }
}

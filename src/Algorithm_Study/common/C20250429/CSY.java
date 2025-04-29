package Algorithm_Study.common.C20250429;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CSY {

    static int N;
    static int[][] Map;
    static int[][] dist;   // 거리배열
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    static class Node implements Comparable<Node> {
        int r, c, cost;

        public Node(int r, int c, int cost) {
            this.r = r;
            this.c = c;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {
            sb.append("#").append(tc).append(" ");
            N = Integer.parseInt(br.readLine());
            Map = new int[N][N];
            dist = new int[N][N];

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    Map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = Integer.MAX_VALUE; // 거리 배열 초기화
                }
            }//input

            dijkstra();

            sb.append(dist[N-1][N-1]).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(0, 0, 0)); // (0,0)에서 출발
        dist[0][0] = 0; //비용 0

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            // 만약 이미 더 짧은 경로로 온 적이 있다면 패스
            if (cur.cost > dist[cur.r][cur.c]) continue;

            for (int d = 0; d < 4; d++) {
                int nr = cur.r + dr[d];
                int nc = cur.c + dc[d];

                // 범위 벗어나면 무시
                if (nr < 0 || nr >= N || nc < 0 || nc >= N) continue;

                // 이동 비용 계산
                int diff = Map[nr][nc] - Map[cur.r][cur.c];
                int moveCost;
                if (diff < 0) moveCost = 0; // 내리막
                else if (diff == 0) moveCost = 1; // 평지
                else moveCost = diff * 2; // 오르막

                int nextCost = cur.cost + moveCost; // 누적비용

                // 더 적은 비용으로 갈 수 있으면 갱신
                if (nextCost < dist[nr][nc]) {
                    dist[nr][nc] = nextCost;
                    pq.offer(new Node(nr, nc, nextCost));
                }
            }
        }
    }
}


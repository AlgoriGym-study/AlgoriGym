package Algorithm_Study.common.C202509.C20250903;

import java.io.*;
import java.util.*;

// 백준 4485번 녹색 옷 입은 애가 젤다지?
public class KMR0041 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int tc = 1;

        int[] dr = {-1, 0, 0, 1}; //상우좌하
        int[] dc = {0, 1, -1, 0};

        while (N != 0) {
            int[][] map = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            } // 입력

            // 다익스트라: 최소 비용 구하기
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
            pq.offer(new int[] {0, 0, map[0][0]});

            int[][] distance = new int[N][N];
            for (int i = 0; i < N; i++) {
                Arrays.fill(distance[i], Integer.MAX_VALUE);
            }
            distance[0][0] = map[0][0];

            while (!pq.isEmpty()) {
                int[] cur = pq.poll();
                int r = cur[0];
                int c = cur[1];
                int dis = cur[2];

                if (dis > distance[r][c]) continue;
                if(r == N - 1 && c == N - 1) break;

                for (int d = 0; d < 4; d++) {
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                    if (distance[nr][nc] > distance[r][c] + map[nr][nc]) {
                        distance[nr][nc] = distance[r][c] + map[nr][nc];
                        pq.offer(new int[]{nr, nc, distance[nr][nc]});
                    }
                }
            }// 다익스트라

            System.out.printf("Problem %d: %d\n", tc++, distance[N - 1][N - 1]);

            N = Integer.parseInt(br.readLine());
        }
        br.close();
    }
}

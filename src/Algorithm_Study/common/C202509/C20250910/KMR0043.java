package Algorithm_Study.common.C202509.C20250910;

import java.io.*;
import java.util.*;

// 백준 2206 벽 부수고 이동하기
public class KMR0043 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        boolean[][][] visited = new boolean[N][M][2]; // [행][열][벽부순여부(0:안부숨, 1:부숨)]
        visited[0][0][0] = true;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, 0, 1}); // r, c, used, distance

        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], used = cur[2], dis = cur[3];

            if (r == N - 1 && c == M - 1) {
                System.out.println(dis);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];

                if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

                if (map[nr][nc] == 0) { // 빈 공간
                    if (!visited[nr][nc][used]) {
                        visited[nr][nc][used] = true;
                        queue.offer(new int[]{nr, nc, used, dis + 1});
                    }
                } else { // 벽
                    if (used == 0 && !visited[nr][nc][1]) { // 아직 벽을 안 부쉈다면
                        visited[nr][nc][1] = true;
                        queue.offer(new int[]{nr, nc, 1, dis + 1});
                    }
                }
            }// for
        }// while

        System.out.println(-1);
        br.close();
    }// main
}

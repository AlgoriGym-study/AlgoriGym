package Algorithm_Study.daily.LYW;

import java.io.*;
import java.util.*;

public class D2025_11_28_1 {
	static int N;
    static int[][] map;
    static int sharkSize = 2;
    static int exp = 0;

    static final int[] dr = {-1, 0, 0, 1};
    static final int[] dc = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int sr = 0, sc = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    sr = i; sc = j;
                    map[i][j] = 0;
                }
            }
        }

        int totalTime = 0;

        while (true) {
            int[] target = findNextTarget(sr, sc);
            if (target == null) break;

            int tr = target[0], tc = target[1], dist = target[2];

            totalTime += dist;
            exp++;
            map[tr][tc] = 0; 
            sr = tr; sc = tc;

            if (exp == sharkSize) {
                sharkSize++;
                exp = 0;
            }
        }

        System.out.println(totalTime);
    }

    static int[] findNextTarget(int sr, int sc) {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        dist[sr][sc] = 0;

        int bestR = -1, bestC = -1, bestD = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];
            int d = dist[r][c];

            if (d > bestD) continue;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (dist[nr][nc] != -1) continue;

                if (map[nr][nc] > sharkSize) continue;

                dist[nr][nc] = d + 1;

                if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
                    if (bestD > dist[nr][nc] ||
                       (bestD == dist[nr][nc] && (nr < bestR || (nr == bestR && nc < bestC)))) {
                        bestD = dist[nr][nc];
                        bestR = nr;
                        bestC = nc;
                    }
                } else {
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        if (bestR == -1) return null;
        return new int[]{bestR, bestC, bestD};
    }
}

package Algorithm_Study.common.C202509.C20250903;

import java.io.*;
import java.util.*;

public class LYW0040 {
	static int N;
    static int[][] map;
    static int sharkSize = 2;
    static int exp = 0;

    // 위, 좌, 우, 아래 (문제의 우선순위를 맞추려면 탐색 순서는 상/좌/우/하가 일반적)
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
                    map[i][j] = 0; // 시작 위치 비워두기
                }
            }
        }

        int totalTime = 0;

        while (true) {
            // 다음 목표 물고기 찾기: {r, c, dist} 또는 null
            int[] target = findNextTarget(sr, sc);
            if (target == null) break;

            int tr = target[0], tc = target[1], dist = target[2];

            // 이동 및 섭취
            totalTime += dist;
            exp++;
            map[tr][tc] = 0; // 먹은 자리 비우기
            sr = tr; sc = tc;

            // 성장 체크
            if (exp == sharkSize) {
                sharkSize++;
                exp = 0;
            }
        }

        System.out.println(totalTime);
    }

    /**
     * 상어 현재 위치에서 BFS로 가장 가까운 먹이(작은 물고기) 탐색.
     * 반환: {r, c, dist} (없으면 null)
     */
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

            // 이미 현재까지 찾은 최단 먹이 거리보다 커지면 더 볼 필요 없음
            if (d > bestD) continue;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (dist[nr][nc] != -1) continue;

                // 지나갈 수 있는지 (상어보다 큰 물고기면 불가)
                if (map[nr][nc] > sharkSize) continue;

                dist[nr][nc] = d + 1;

                // 먹을 수 있는지 (자기보다 작은 물고기)
                if (map[nr][nc] > 0 && map[nr][nc] < sharkSize) {
                    // 더 가까운 먹이를 찾았거나, 같은 거리면 행/열 우선순위 비교
                    if (bestD > dist[nr][nc] ||
                       (bestD == dist[nr][nc] && (nr < bestR || (nr == bestR && nc < bestC)))) {
                        bestD = dist[nr][nc];
                        bestR = nr;
                        bestC = nc;
                    }
                    // 같은 거리의 다른 후보도 계속 탐색(같은 레벨에서 더 위/왼쪽이 있을 수 있으므로)
                } else {
                    // 빈칸이거나 같은 크기의 물고기면 계속 진행 가능
                    q.offer(new int[]{nr, nc});
                }
            }
        }

        if (bestR == -1) return null;
        return new int[]{bestR, bestC, bestD};
    }
}

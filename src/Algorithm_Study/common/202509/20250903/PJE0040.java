package Algorithm_Study.common.202509.20250903;
import java.util.*;

// 백준 아기상어
public class PJE0040 {
    static int N;
    static int[][] map;
    static int sr, sc;            // 상어 위치
    static int size = 2;          // 상어 크기
    static int eaten = 0;         // 현재 크기에서 먹은 수
    static int time = 0;          // 총 이동 시간

    // 상, 좌, 우, 하
    static final int[] dr = {-1, 0, 0, 1};
    static final int[] dc = { 0,-1, 1, 0};

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        N = scn.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = scn.nextInt();
                if (map[i][j] == 9) {
                    sr = i; sc = j;
                    map[i][j] = 0; // 상어 시작 위치 빈 칸으로
                }
            }
        }

        // 먹을 게 없어질 때까지 반복
        while (true) {
            int[] target = bfsFindTarget(); // {tr, tc, dist}
            if (target == null) break;      // 더 이상 먹을 물고기 없음

            // 이동 및 시간 누적
            int tr = target[0], tc = target[1], dist = target[2];
            time += dist;

            // 상어 위치 업데이트
            sr = tr; sc = tc;

            // 먹기
            map[tr][tc] = 0;
            eaten++;
            if (eaten == size) {
                size++;
                eaten = 0;
            }
        }

        System.out.println(time);
        scn.close();
    }

    // BFS로 현재 상어 위치에서 가장 가까운 먹잇감 찾기
    // 반환: {행, 열, 거리} 또는 null
    static int[] bfsFindTarget() {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(dist[i], -1);

        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{sr, sc});
        dist[sr][sc] = 0;

        int tr = -1, tc = -1, minD = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0], c = cur[1];

            // 현재 위치가 먹을 수 있는 물고기인지 확인
            if (map[r][c] > 0 && map[r][c] < size) {
                int d = dist[r][c];
                if (d < minD || (d == minD && (r < tr || (r == tr && c < tc)))) {
                    minD = d;
                    tr = r; tc = c;
                }
                // 주의: 같은 거리 안에서도 더 위/왼쪽 후보가 있을 수 있어
                // 계속 탐색하지만, dist가 증가하면 더 볼 필요 없음
                continue;
            }

            // 4방향 확장 (size 이하만 지나갈 수 있음)
            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                if (nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if (dist[nr][nc] != -1) continue;
                if (map[nr][nc] > size) continue; // 지나갈 수 없음(더 큰 물고기)

                dist[nr][nc] = dist[r][c] + 1;

                // 이미 최소 먹이 거리(minD)를 찾았으면, 그보다 먼 거리 탐색은 생략
                if (dist[nr][nc] <= minD) q.add(new int[]{nr, nc});
            }
        }

        if (tr == -1) return null; // 먹을 수 있는 물고기 없음
        return new int[]{tr, tc, minD};
    }
}

package Algorithm_Study.common.C202509.C20250910;

import java.util.*;

public class LYW0043 {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited; // [x][y][0]: 벽 안 부숨, [x][y][1]: 벽 부숨

    static final int[] dx = {-1, 1, 0, 0};
    static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = sc.next(); // 입력
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    static int bfs() {
        Deque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 1, 0}); // x, y, 거리, 벽 부순 횟수
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2], broken = cur[3];

            if (x == N - 1 && y == M - 1) return dist; // 도착 시 최단거리 반환

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 빈 칸 이동 (현재 상태 유지)
                if (map[nx][ny] == 0 && !visited[nx][ny][broken]) {
                    visited[nx][ny][broken] = true;
                    q.offer(new int[]{nx, ny, dist + 1, broken});
                }

                // 벽이면 한 번만 부수고 이동 가능
                if (map[nx][ny] == 1 && broken == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.offer(new int[]{nx, ny, dist + 1, 1});
                }
            }
        }
        return -1; // 도달 불가
    }
}

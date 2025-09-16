package Algorithm_Study.common.C202509.C20250910;
import java.util.*;

// 백준 벽 부수고 이동하기
class PJE0043 {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited; // [N][M][2]

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = sc.next(); // 한 줄 입력 (0과 1이 붙어서 들어옴)
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        // x, y, dist, wall
        q.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            int wall = cur[3];

            // 도착지 도달
            if (x == N - 1 && y == M - 1) {
                return dist;
            }

            // 4방향 탐색
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 이동 가능한 곳일 때
                if (map[nx][ny] == 0 && !visited[nx][ny][wall]) {
                    visited[nx][ny][wall] = true;
                    q.offer(new int[]{nx, ny, dist + 1, wall});
                }

                // 벽이고 아직 안 부쉈을 때
                if (map[nx][ny] == 1 && wall == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    q.offer(new int[]{nx, ny, dist + 1, 1});
                }
            }
        }
        return -1;
    }
}

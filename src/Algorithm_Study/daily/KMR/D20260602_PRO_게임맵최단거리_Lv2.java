package Algorithm_Study.daily.KMR;

import java.util.*;

public class D20260602_PRO_게임맵최단거리_Lv2 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == n - 1 && y == m - 1) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (maps[nx][ny] == 0) continue;
                if (visited[nx][ny]) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return -1;
    }
}

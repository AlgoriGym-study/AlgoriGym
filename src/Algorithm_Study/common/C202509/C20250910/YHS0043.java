package Algorithm_Study.common.C202509.C20250910;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class YHS0043 {

    static class Node {
        int x, y, count, wall;

        public Node(int x, int y, int count, int wall) {
            this.x = x;
            this.y = y;
            this.count = count;
            this.wall = wall;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        visited = new boolean[N][M][2];
        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y, 1, 0));
        visited[x][y][0] = true;
        visited[x][y][1] = true;

        while (!q.isEmpty()) {
            Node now = q.poll();

            if (now.x == N - 1 && now.y == M - 1) {
                return now.count;
            }

            for (int d = 0; d < 4; d++) {
                int nx = now.x + dr[d];
                int ny = now.y + dc[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    //벽이 아닌 경우
                    if (map[nx][ny] == 0) {
                        if (!visited[nx][ny][now.wall]) {
                            visited[nx][ny][now.wall] = true;
                            q.add(new Node(nx, ny, now.count + 1, now.wall));
                        }
                    }
                    //벽인 경우
                    else {
                        if (now.wall == 0 && !visited[nx][ny][1]) {
                            visited[nx][ny][1] = true;
                            q.add(new Node(nx, ny, now.count + 1, 1));
                        }
                    }
                }
            }
        }

        return -1;
    }
}

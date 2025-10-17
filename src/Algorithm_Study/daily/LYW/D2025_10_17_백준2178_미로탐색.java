package Algorithm_Study.daily.LYW;

import java.util.*;

public class D2025_10_17_백준2178_미로탐색 {
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상, 하, 좌, 우
    static int[] dy = {0, 0, -1, 1};

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void bfs(int startX, int startY) {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(startX, startY));
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (!visited[nextX][nextY] && maze[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        maze[nextX][nextY] = maze[current.x][current.y] + 1;
                        queue.offer(new Point(nextX, nextY));
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine(); // 개행 문자 제거

        maze = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = line.charAt(j) - '0';
            }
        }

        bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }
}

package Algorithm_Study.common.C20250422;

import java.util.*;
import java.io.*;

public class YHS {
    static final int HEIGHT = 12;
    static final int WIDTH = 6;
    static char[][] map;
    static boolean[][] visited;
    static List<Puyo> list;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        map = new char[HEIGHT][WIDTH];

        for (int i = 0; i < HEIGHT; i++) {
            String line = br.readLine();
            for (int j = 0; j < WIDTH; j++) {
                map[i][j] = line.charAt(j);
            }
        }

        int count = 0;
        while (true) {
            boolean isFinished = true;
            visited = new boolean[HEIGHT][WIDTH];
            for (int i = 0; i < HEIGHT; i++) {
                for (int j = 0; j < WIDTH; j++) {
                    char ch = map[i][j];
                    if (ch != '.') {
                        list = new ArrayList<>();
                        bfs(ch,i,j);

                        if (list.size() >= 4) {
                            isFinished = false;
                            for (Puyo puyo : list) {
                                map[puyo.x][puyo.y] = '.';
                            }
                        }
                    }
                }
            }
            if (isFinished)
                break;
            FallPuyos();
            count++;
        }

        System.out.println(count);
    }

    static void bfs(char color, int x, int y) {
        Queue<Puyo> q = new LinkedList<>();
        q.add(new Puyo(x, y));
        visited[x][y] = true;
        list.add(new Puyo(x,y));

        while (!q.isEmpty()) {
            Puyo puyo = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = puyo.x + dr[d];
                int ny = puyo.y + dc[d];

                if (nx < 0 || nx >= HEIGHT || ny < 0 || ny >= WIDTH) continue;
                if (visited[nx][ny]) continue;
                if (map[nx][ny] != color) continue;

                visited[nx][ny] = true;
                list.add(new Puyo(nx, ny));
                q.add(new Puyo(nx, ny));
            }
        }
    }

    static void FallPuyos() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = HEIGHT-1; j >= 0; j--) {
                if (map[j][i] == '.') {
                    for (int k = j-1; k >= 0; k--) {
                        if (map[k][i] != '.') {
                            map[j][i] = map[k][i];
                            map[k][i] = '.';
                            break;
                        }
                    }
                }
            }
        }
    }

    static class Puyo {
        int x, y;

        public Puyo(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

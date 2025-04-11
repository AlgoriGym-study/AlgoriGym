package Algorithm_Study.daily.YHS;

import java.util.*;
import java.io.*;

public class D20250411_미로1 {
    static int[][] maze;
    static boolean[][] visited;
    static int[] dr = { -1, 1, 0, 0 };
    static int[] dc = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int tc = 1; tc <= 10; tc++) {
            int t = Integer.parseInt(br.readLine());

            maze = new int[16][16];
            visited = new boolean[16][16];

            int startx = 0;
            int starty = 0;
            for (int i = 0; i < 16; i++) {
                String str = br.readLine();
                for (int j = 0; j < 16; j++) {
                    maze[i][j] = Character.getNumericValue(str.charAt(j));
                    if (maze[i][j] == 2) {
                        startx = i;
                        starty = j;
                    }
                }
            }

            System.out.printf("#%d %d\n", t, bfs(startx, starty) ? 1 : 0);
        }
    }

    static boolean bfs(int r, int c) {
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(r, c));
        visited[r][c] = true;

        while (!q.isEmpty()) {
            Person p = q.poll();

            for (int d = 0; d < 4; d++) {
                int nr = p.x + dr[d];
                int nc = p.y + dc[d];

                if (nr < 0 || nr >= 16 || nc < 0 || nc >= 16)
                    continue;
                if (visited[nr][nc] || maze[nr][nc] == 1)
                    continue;

                if (maze[nr][nc] == 3)
                    return true;

                visited[nr][nc] = true;
                q.add(new Person(nr, nc));
            }
        }

        return false;
    }

    static class Person {
        int x, y;

        public Person(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

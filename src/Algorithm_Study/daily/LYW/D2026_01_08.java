package Algorithm_Study.daily.LYW;

import java.io.*;
import java.util.*;

public class D2026_01_08 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        long K = Long.parseLong(br.readLine().trim());

        long total = (long) C * R;
        if (K > total) {
            System.out.print(0);
            return;
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        boolean[][] visited = new boolean[R + 1][C + 1];

        int x = 1, y = 1;
        int dir = 0;
        long cnt = 1;
        visited[y][x] = true;

        while (cnt < K) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 1 || nx > C || ny < 1 || ny > R || visited[ny][nx]) {
                dir = (dir + 1) % 4;
                continue;
            }

            x = nx;
            y = ny;
            visited[y][x] = true;
            cnt++;
        }

        System.out.print(x + " " + y);
    }
}

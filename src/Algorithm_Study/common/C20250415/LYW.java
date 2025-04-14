package Algorithm_Study.common.C20250415;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class LYW {

    static class State {
        int r, c, dir, cut, cmd;

        public State(int r, int c, int dir, int cut, int cmd) {
            this.r = r;
            this.c = c;
            this.dir = dir;
            this.cut = cut;
            this.cmd = cmd;
        }
    }

    static int N, K;
    static char[][] map;
    static int[] start = new int[2];
    static int[] end = new int[2];

    // 상 우 하 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                map[i] = br.readLine().toCharArray();
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == 'X') {
                        start[0] = i;
                        start[1] = j;
                    }
                    if (map[i][j] == 'Y') {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }

            int result = bfs();
            sb.append("#").append(tc).append(" ").append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int bfs() {
        Queue<State> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][N][4][K + 1];

        // 시작 위치에서 모든 방향으로 시작 가능
        for (int d = 0; d < 4; d++) {
            visited[start[0]][start[1]][d][0] = true;
            q.offer(new State(start[0], start[1], d, 0, 0));
        }

        while (!q.isEmpty()) {
            State cur = q.poll();

            if (cur.r == end[0] && cur.c == end[1]) return cur.cmd;

            // 전진
            int nr = cur.r + dr[cur.dir];
            int nc = cur.c + dc[cur.dir];

            if (inRange(nr, nc)) {
                char next = map[nr][nc];
                if ((next == 'G' || next == 'Y') && !visited[nr][nc][cur.dir][cur.cut]) {
                    visited[nr][nc][cur.dir][cur.cut] = true;
                    q.offer(new State(nr, nc, cur.dir, cur.cut, cur.cmd + 1));
                } else if (next == 'T' && cur.cut < K && !visited[nr][nc][cur.dir][cur.cut + 1]) {
                    visited[nr][nc][cur.dir][cur.cut + 1] = true;
                    q.offer(new State(nr, nc, cur.dir, cur.cut + 1, cur.cmd + 1));
                }
            }

            // 좌/우 회전
            for (int turn = -1; turn <= 1; turn += 2) {
                int nd = (cur.dir + turn + 4) % 4;
                if (!visited[cur.r][cur.c][nd][cur.cut]) {
                    visited[cur.r][cur.c][nd][cur.cut] = true;
                    q.offer(new State(cur.r, cur.c, nd, cur.cut, cur.cmd + 1));
                }
            }
        }

        return -1;
    }

    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}


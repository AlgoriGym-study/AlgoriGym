package Algorithm_Study.common.C202504.C20250415;

import java.util.*;

public class LYW {

    static class State {
        int r, c;       // 위치 (행, 열)
        int dir;        // 바라보는 방향 (0: 상, 1: 우, 2: 하, 3: 좌)
        int cut;        // 지금까지 벤 나무 수
        int cmd;        // 지금까지 사용한 조작 횟수

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

    // 방향: 상, 우, 하, 좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();  // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt(); // 맵 크기
            K = sc.nextInt(); // 벌목 가능 횟수

            map = new char[N][N];
            for (int i = 0; i < N; i++) {
                String row = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = row.charAt(j);

                    // 시작점과 도착점 위치 저장
                    if (map[i][j] == 'X') {
                        start[0] = i;
                        start[1] = j;
                    } else if (map[i][j] == 'Y') {
                        end[0] = i;
                        end[1] = j;
                    }
                }
            }

            int result = bfs();  // 최소 조작 횟수 계산
            System.out.println("#" + tc + " " + result);
        }
    }

    // 최소 조작 횟수를 구하는 BFS
    static int bfs() {
        Queue<State> q = new LinkedList<>();
        boolean[][][][] visited = new boolean[N][N][4][K + 1];

        // 출발지에서 모든 방향으로 시작 가능하도록 초기화
        for (int d = 0; d < 4; d++) {
            visited[start[0]][start[1]][d][0] = true;
            q.offer(new State(start[0], start[1], d, 0, 0));
        }

        while (!q.isEmpty()) {
            State cur = q.poll();

            // 목적지에 도착하면 조작 횟수 반환
            if (cur.r == end[0] && cur.c == end[1]) return cur.cmd;

            // 전진
            int nr = cur.r + dr[cur.dir];
            int nc = cur.c + dc[cur.dir];

            if (inRange(nr, nc)) {
                char next = map[nr][nc];

                // 땅 또는 도착지일 경우 그냥 전진
                if ((next == 'G' || next == 'Y') && !visited[nr][nc][cur.dir][cur.cut]) {
                    visited[nr][nc][cur.dir][cur.cut] = true;
                    q.offer(new State(nr, nc, cur.dir, cur.cut, cur.cmd + 1));
                }

                // 나무일 경우 베고 전진 (벌목 가능 횟수 남았을 때만)
                else if (next == 'T' && cur.cut < K && !visited[nr][nc][cur.dir][cur.cut + 1]) {
                    visited[nr][nc][cur.dir][cur.cut + 1] = true;
                    q.offer(new State(nr, nc, cur.dir, cur.cut + 1, cur.cmd + 1));
                }
            }

            // 좌회전과 우회전
            for (int turn = -1; turn <= 1; turn += 2) {
                int nd = (cur.dir + turn + 4) % 4; // 회전 방향 (0~3 유지)
                if (!visited[cur.r][cur.c][nd][cur.cut]) {
                    visited[cur.r][cur.c][nd][cur.cut] = true;
                    q.offer(new State(cur.r, cur.c, nd, cur.cut, cur.cmd + 1));
                }
            }
        }

        return -1; // 도착할 수 없는 경우
    }

    // 맵 범위 확인
    static boolean inRange(int r, int c) {
        return 0 <= r && r < N && 0 <= c && c < N;
    }
}

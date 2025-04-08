package Algorithm_Study.common.C20250408;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CSY {

        static int N, M, R, C, L, count;
        static int[][] map;
        static boolean[][] visited;

        static int[] dr = {-1, 1, 0, 0};
        static int[] dc = {0, 0, -1, 1};

        static int[][] dirBytype = {
            {}, // 0번
            {0, 1, 2, 3}, // 1번 : 상하좌우
            {0, 1},
            {2, 3},
            {0, 3},
            {1, 3},
            {1, 2},
            {0, 2}
        };

        static int[] opposite = {1, 0, 3, 2};
//
//        static int[] d1 = {-1, 0, 1, 0, 0, -1, 0, 1}; // 상하좌우
//        static int[] d2 = {-1, 0, 1, 0}; // 상하
//        static int[] d3 = {0, -1, 0, 1}; // 좌우
//        static int[] d4 = {-1, 0, 0, 1}; // 상우
//        static int[] d5 = {1, 0, 0, 1}; // 하우
//        static int[] d6 = {1, 0, 0, -1}; // 하좌
//        static int[] d7 = {-1, 0, 0, -1}; // 상좌

        static boolean isValid(int r, int c) {
            return r >= 0 && r < N && c >= 0 && c < M;
        }

        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int T = Integer.parseInt(br.readLine());

            for(int tc = 1; tc <= T; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken());
                M = Integer.parseInt(st.nextToken());
                R = Integer.parseInt(st.nextToken());
                C = Integer.parseInt(st.nextToken());
                L = Integer.parseInt(st.nextToken());

                map = new int[N][M];
                visited = new boolean[N][M];
                for(int i = 0; i < N; i++) {
                    st = new StringTokenizer(br.readLine());
                    for(int j = 0; j < M; j++) {
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }// input

                bfs();

                System.out.println("#" + tc + " " + count);

            }
        }

        static void bfs() {
            Queue<int[]> q = new LinkedList<>();
            visited[R][C] = true;
            q.add(new int[] {R, C, 1}); // 위치, 시간

            count = 1;
            while(!q.isEmpty()) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int t = curr[2];

                if(t >= L) continue; // 시간 오버하면 끝

                int type = map[r][c]; // 맨홀 종류 찾기!!
                for(int d : dirBytype[type]) { // 해당 맨홀에 대해 델타 좌표 돌리기
                    int nr = r + dr[d];
                    int nc = c + dc[d];

                    // 유효성 및 방문 체크
                    if(!isValid(nr, nc) || visited[nr][nc]) continue;

                    int nextType = map[nr][nc];
                    if(nextType == 0) continue;

                    boolean canConnect = false;
                    for(int nd : dirBytype[nextType]) {
                        if(nd == opposite[d]) { // 다음 맨홀과 현재 맨홀이 연결된다면 다음으로 넘어가기!!
                            canConnect = true;
                            break;
                        }
                    }

                    if(canConnect) {
                        visited[nr][nc] = true;
                        q.add(new int[] {nr, nc, t+1});
                        count++;
                    }

                }
            }
        }

    }

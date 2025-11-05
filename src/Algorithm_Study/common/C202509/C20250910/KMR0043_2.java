package Algorithm_Study.common.C202509.C20250910;

import java.util.*;
import java.io.*;

public class KMR0043_2 {
    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int answer;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(String.valueOf(line.charAt(j)));
            }
        }

        visited = new boolean[N][M][2];
        visited[0][0][0] = true;

        answer = Integer.MAX_VALUE; // -1 대신 큰 값으로 초기화
        dfs(0, 0, 0, 1);

        System.out.println(answer == Integer.MAX_VALUE ? -1 : answer);
        br.close();
    }

    static void dfs(int r, int c, int crushed, int count) {
        if (r == N - 1 && c == M - 1) {
            answer = Math.min(answer, count);
            return;
        }

        // 가지치기: 현재 count가 이미 찾은 최단 경로보다 크거나 같으면 중단
        if (count >= answer) return;

        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0 || nr >= N || nc >= M) continue;

            // 빈 공간으로 이동
            if (map[nr][nc] == 0) {
                if (!visited[nr][nc][crushed]) {
                    visited[nr][nc][crushed] = true;
                    dfs(nr, nc, crushed, count + 1); // crushed 상태 유지
                    visited[nr][nc][crushed] = false;
                }
            }
            // 벽을 부수고 이동 (아직 부수지 않았을 때만)
            else if (map[nr][nc] == 1 && crushed == 0) {
                if (!visited[nr][nc][1]) {
                    visited[nr][nc][1] = true;
                    dfs(nr, nc, 1, count + 1); // crushed를 1로 변경해서 전달
                    visited[nr][nc][1] = false;
                }
            }
        }
    }
}
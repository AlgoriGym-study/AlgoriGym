package Algorithm_Study.common.C202509.C20250917;

import java.io.*;
import java.util.*;

// 알파벳
public class KMR0044 {

    static int R, C;
    static char[][] map;
    static Set<Character> alphabet;
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    static boolean[][] visited;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = line.charAt(j);
            }
        }// 입력

        // 초기 세팅
        alphabet = new HashSet<>();
        alphabet.add(map[0][0]);
        visited = new boolean[R][C];
        visited[0][0] = true;
        answer = 0;

        dfs(0, 0);
        System.out.println(answer);

        br.close();
    }


    static void dfs(int r, int c) {
        // 종료 조건

        //dr, dc 이동
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];

            if (nr < 0 || nc < 0|| nr >= R || nc >= C) {
                answer = Math.max(answer, alphabet.size());
                continue;
            }
            if (visited[nr][nc]) {
                answer = Math.max(answer, alphabet.size());
                continue;
            }
            if (alphabet.contains(map[nr][nc])) {
                answer = Math.max(answer, alphabet.size());
                continue;
            }

            // 조건 통과 -> 다음 칸이 될 수 있음
            visited[nr][nc] = true;
            alphabet.add(map[nr][nc]);

            dfs(nr, nc);

            visited[nr][nc] = false;
            alphabet.remove(map[nr][nc]);
        }

    }
}

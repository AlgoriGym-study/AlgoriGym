package Algorithm_Study.common.C202508.C20250806;

import java.util.*;

public class KMR0039_1 {
    static int N;
    static int[][][] snake;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[][] map = new int[N][N];

        int K = sc.nextInt();
        for (int i = 0; i < K; i++) {
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            map[r][c] = 1;
        } // 사과 입력

        int L = sc.nextInt();
        Map<Integer, String> trans = new HashMap<>();
        for (int i = 0; i < L; i++) {
            trans.put(sc.nextInt(), sc.next());
        }// 방향 전환 입력

        // 초기화
        int now = 0;
        int length = 1;
        int[] head = new int[] {0, 0, 0};
        snake = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(snake[i][j], -1_000_000);
            }
        }
        snake[0][0][0] = 0;

        int[] dr = {0, 1, 0, -1}; // 우 -> 하 -> 좌 -> 상
        int[] dc = {1, 0, -1, 0};

        while (true) {
            if (trans.containsKey(now)) {
                switch(trans.get(now)) {
                    case "D":
                        head[2] = (1 + head[2]) % 4;
                        break;
                    case "L":
                        head[2] = (3 + head[2]) % 4;
                }
            }// 방향 전환

            // 이동
            now++;
            int nr = head[0] + dr[head[2]];
            int nc = head[1] + dc[head[2]];

            if(!isOnMap(nr, nc)) break;
            if(isBlocked(nr, nc, now, length)) break;

            head[0] = nr;
            head[1] = nc;

            // 사과
            if (map[nr][nc] == 1) {
                length++;
                map[nr][nc] = 0;
            }

            snake[nr][nc][head[2]] = now;
        }

        System.out.println(now);

        sc.close();
    } // main

    static boolean isOnMap(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }

    static boolean isBlocked(int nr, int nc, int now, int length) {
        for (int i = 0; i < 4; i++) {
            if (now - snake[nr][nc][i] > length) continue;
            return true;
        }
        return false;
    }
}
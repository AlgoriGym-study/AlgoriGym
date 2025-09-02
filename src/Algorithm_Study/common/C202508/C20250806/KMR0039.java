package Algorithm_Study.common.C202508.C20250806;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KMR0039 {

    static class Point {
        int r, c;
        Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int K = Integer.parseInt(br.readLine().trim());

        boolean[][] apple = new boolean[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            apple[r][c] = true;
        }

        int L = Integer.parseInt(br.readLine().trim());
        Map<Integer, Character> turn = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char c = st.nextToken().charAt(0);
            turn.put(t, c);
        }

        // 우, 하, 좌, 상
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int dir = 0;

        Deque<Point> snake = new ArrayDeque<>();
        snake.addFirst(new Point(1, 1));

        // O(1) 충돌 판정용: 좌표 인코딩 key =  r * N + c
        Set<Integer> occupied = new HashSet<>();
        occupied.add(encode(1, 1, N));

        int time = 0;
        int r = 1, c = 1;

        while (true) {
            time++;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            // 벽 충돌
            if (nr < 1 || nr > N || nc < 1 || nc > N) {
                System.out.println(time);
                return;
            }
            int key = encode(nr, nc, N);

            // 자기 몸 충돌
            if (occupied.contains(key)) {
                System.out.println(time);
                return;
            }

            // 머리 전진
            snake.addFirst(new Point(nr, nc));
            occupied.add(key);

            // 사과 있으면 꼬리 그대로, 없으면 꼬리 한 칸 줄이기
            if (apple[nr][nc]) {
                apple[nr][nc] = false; // 사과 먹음
            } else {
                Point tail = snake.removeLast();
                occupied.remove(encode(tail.r, tail.c, N));
            }

            // 현재 시간(time) 끝난 뒤 회전 적용
            if (turn.containsKey(time)) {
                char t = turn.get(time);
                if (t == 'L') dir = (dir + 3) % 4; // 왼쪽(반시계)
                else if (t == 'D') dir = (dir + 1) % 4; // 오른쪽(시계)
            }

            r = nr; c = nc;
        }
    }

    private static int encode(int r, int c, int N) {
        return r * N + c;
    }
}

package Algorithm_Study.common.C202508.C20250806;

import java.io.*;
import java.util.*;

// 백준 3190 뱀
public class KMR0039_2 {

    static int N;
    static Set<Integer> snakeValue;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[N + 1][N + 1];
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            map[r][c] = 1; // 사과
        }

        int L = Integer.parseInt(br.readLine());
        Map<Integer, Character> directionTurning = new HashMap<>();
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char d = st.nextToken().charAt(0);
            directionTurning.put(t, d);
        }

        Deque<int[]> snake = new ArrayDeque<>();
        snake.addFirst(new int[]{1, 1});
        snakeValue = new HashSet<>();
        snakeValue.add(1 * N + 1);

        int time = 0;
        int direction = 0;
        int[] dr = {0, 1, 0, -1}; //우 하 좌 상
        int[] dc = {1, 0, -1, 0};

        while(true) {
            time++;

            int[] head = snake.peekFirst();
            int nr = head[0] + dr[direction];
            int nc = head[1] + dc[direction];

            if (nr < 1 || nc < 1 || nr > N || nc > N) break;
            if (isCrushed(nr, nc)) break;

            // 벽에 부딪히지 않음 -> 사과 확인
            if (map[nr][nc] == 1) {
                // 꼬리 유지, 머리만 추가
                snake.addFirst(new int[]{nr, nc});
                snakeValue.add(nr * N + nc);
                map[nr][nc] = 0;
            } else {
                // 꼬리 삭제, 머리 추가
                int[] tail = snake.pollLast();
                snakeValue.remove(tail[0] * N + tail[1]);

                snake.addFirst(new int[]{nr, nc});
                snakeValue.add(nr * N + nc);
            }



            // 방향 전환 확인
            if (directionTurning.containsKey(time)) {
                if (directionTurning.get(time) == 'L') {
                    direction = (direction + 3) % 4;
                } else {
                    direction = (direction + 1) % 4;
                }
            }
        }

        System.out.print(time);
        br.close();
    }

    static boolean isCrushed(int nr, int nc) {
        return snakeValue.contains(nr * N + nc);
    }
}

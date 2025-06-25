package Algorithm_Study.common.C202504.C20250422;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class LYW {

    static char[][] map;
    static int N = 12, M = 6, ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = sc.next().toCharArray();
        }

        ans = 0;

        while (true) {
            boolean popped = false;
            boolean[][] visited = new boolean[N][M];  // 방문 배열 매 반복마다 초기화

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        List<int[]> puyos = bfs(i, j, visited);
                        if (puyos.size() >= 4) {
                            popped = true;
                            for (int[] p : puyos) {
                                map[p[0]][p[1]] = '.';
                            }
                        }
                    }
                }
            }

            if (!popped) break; // 더 이상 터뜨릴 게 없으면 종료
            applyGravity();
            ans++; // 연쇄 증가
        }

        System.out.println(ans);
    }

    static List<int[]> bfs(int r, int c, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> puyos = new ArrayList<>();

        char color = map[r][c];
        queue.offer(new int[]{r, c});
        puyos.add(new int[]{r, c});
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int cr = curr[0];
            int cc = curr[1];

            for (int d = 0; d < 4; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];

                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;
                if (visited[nr][nc]) continue;
                if (map[nr][nc] != color) continue;

                visited[nr][nc] = true;
                queue.offer(new int[]{nr, nc});
                puyos.add(new int[]{nr, nc});
            }
        }

        return puyos;
    }

    static void applyGravity() {
        for (int c = 0; c < M; c++) {
            for (int r = N - 1; r >= 0; r--) {
                if (map[r][c] != '.') {
                    int nr = r;
                    while (nr + 1 < N && map[nr + 1][c] == '.') {
                        map[nr + 1][c] = map[nr][c];
                        map[nr][c] = '.';
                        nr++;
                    }
                }
            }
        }
    }
}

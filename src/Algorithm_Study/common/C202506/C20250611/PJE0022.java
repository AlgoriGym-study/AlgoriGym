package Algorithm_Study.common.C202506.C20250611;
import java.util.*;

class PJE0022  {
    static int row, col;
    static char[][] store;
    static boolean[][] vis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(String[] storage, String[] requests) {
        row = storage.length;
        col = storage[0].length();
        store = new char[row + 2][col + 2];

        for (int i = 0; i < row + 2; i++) {
            Arrays.fill(store[i], '0');
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                store[i + 1][j + 1] = storage[i].charAt(j);
            }
        }

        for (int i = 0; i < requests.length; i++) {
            String request = requests[i];
            char target = request.charAt(0);

            bfs();

            if (request.length() == 2) { // 크레인
                for (int r = 1; r <= row; r++) {
                    for (int c = 1; c <= col; c++) {
                        if (store[r][c] == target) {
                            store[r][c] = '0';
                        }
                    }
                }
            } else { // 지게차
                for (int r = 1; r <= row; r++) {
                    for (int c = 1; c <= col; c++) {
                        if (store[r][c] == target) {
                            boolean accessible = false;
                            for (int d = 0; d < 4; d++) {
                                int nr = r + dx[d];
                                int nc = c + dy[d];
                                if (vis[nr][nc]) {
                                    accessible = true;
                                    break;
                                }
                            }
                            if (accessible) {
                                store[r][c] = '0';
                            }
                        }
                    }
                }
            }
        }

        // 남은 컨테이너 개수 세기
        int answer = 0;
        for (int r = 1; r <= row; r++) {
            for (int c = 1; c <= col; c++) {
                if (store[r][c] != '0') {
                    answer++;
                }
            }
        }

        return answer;
    }

    public void bfs() {
        vis = new boolean[row + 2][col + 2];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= row + 2 || ny >= col + 2) continue;
                if (vis[nx][ny]) continue;
                if (store[nx][ny] != '0') continue;

                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }
    }
}

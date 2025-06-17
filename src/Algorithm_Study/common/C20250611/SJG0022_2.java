package Algorithm_Study.common.C20250611;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class SJG0022_2 {
    // 방향: 상, 하, 좌, 우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int row, col;
    static char[][] store;
    static boolean[][] vis;

    public int solution(String[] storage, String[] requests) {
        row = storage.length;
        col = storage[0].length();
        store = new char[row + 2][col + 2];

        // 패딩(0,0)~(row+1,col+1) 전체를 '0'으로 초기화(외부)
        for (int i = 0; i < row + 2; i++) Arrays.fill(store[i], '0');
        // 실제 데이터 복사 (1,1)~(row,col)
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++)
                store[i + 1][j + 1] = storage[i].charAt(j);

        for (String req : requests) {
            char target = req.charAt(0);
            bfs(); // 외부 빈칸 표시

            if (req.length() == 2) {
                // 크레인: target 모두 제거
                for (int r = 1; r <= row; r++)
                    for (int c = 1; c <= col; c++)
                        if (store[r][c] == target)
                            store[r][c] = '0';
            } else {
                // 지게차: 외부와 연결된 target만 제거
                for (int r = 1; r <= row; r++) {
                    for (int c = 1; c <= col; c++) {
                        if (store[r][c] == target) {
                            boolean accessible = false;
                            for (int d = 0; d < 4; d++) {
                                int nr = r + dx[d], nc = c + dy[d];
                                if (vis[nr][nc]) {
                                    accessible = true;
                                    break;
                                }
                            }
                            if (accessible) store[r][c] = '0';
                        }
                    }
                }
            }
        }

        // 남은 컨테이너 개수 세기
        int answer = 0;
        for (int r = 1; r <= row; r++)
            for (int c = 1; c <= col; c++)
                if (store[r][c] != '0')
                    answer++;
        return answer;
    }

    // 외부 빈칸 표시(BFS)
    static void bfs() {
        vis = new boolean[row + 2][col + 2];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        vis[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1];
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= row + 2 || ny >= col + 2) continue;
                if (vis[nx][ny]) continue;
                if (store[nx][ny] != '0') continue;
                vis[nx][ny] = true;
                q.add(new int[]{nx, ny});
            }
        }
    }
}

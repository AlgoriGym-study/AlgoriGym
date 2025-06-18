package Algorithm_Study.common.C20250611;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class SJG0022 {
    private char[][] grid;
    private int n, m;
    
    
    private final int[] dr = { -1, 1, 0, 0 };
    private final int[] dc = { 0, 0, -1, 1 };

    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        grid = new char[n][m];
        
        for (int i = 0; i < n; i++) {
            grid[i] = storage[i].toCharArray();
        }

        
        for (String req : requests) {
            char target = req.charAt(0);

            // 크레인
            if (req.length() == 2 && req.charAt(1) == target) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == target) {
                            grid[i][j] = '.';
                        }
                    }
                }
            }
            // 지게차
            else {
                // 외부 연결된 빈 칸 표시
                boolean[][] external = new boolean[n][m];
                bfs(external);

                // 접근 가능한 target 위치 수집
                List<int[]> removal = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if (grid[i][j] == target && isPossible(i, j, external)) {
                            removal.add(new int[]{i, j});
                        }
                    }
                }
                // 제거
                for (int[] pos : removal) {
                    grid[pos[0]][pos[1]] = '.';
                }
            }
        }

        // 남은 컨테이너 카운팅
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != '.') {
                    count++;
                }
            }
        }
        return count;
    }
    
    // bfs
    private void bfs(boolean[][] external) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];

        // 테두리 네 면에서 빈 칸만 시작점으로
        for (int i = 0; i < n; i++) {
            enqueue(i, 0, q, visited);
            enqueue(i, m - 1, q, visited);
        }
        for (int j = 0; j < m; j++) {
            enqueue(0, j, q, visited);
            enqueue(n - 1, j, q, visited);
        }

        // BFS: 빈 칸만 따라가며 external 표시
        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            external[r][c] = true;

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d], nc = c + dc[d];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
                if (!visited[nr][nc] && grid[nr][nc] == '.') {
                    enqueue(nr, nc, q, visited);
                }
            }
        }
    }

    // r, c가 빈칸이면 큐에 넣고 방문처리
    private void enqueue(int r, int c, Deque<int[]> q, boolean[][] visited) {
        if (!visited[r][c] && grid[r][c] == '.') {
            visited[r][c] = true;
            q.add(new int[]{r, c});
        }
    }

    // 지게차 접근 가능성 판단
    private boolean isPossible(int r, int c, boolean[][] external) {
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d], nc = c + dc[d];
            // 테두리 밖이면 외부와 연결된 셀로 간주
            if (nr < 0 || nr >= n || nc < 0 || nc >= m) {
                return true;
            }
            if (external[nr][nc]) {
                return true;
            }
        }
        return false;
    }
}

import java.util.*;

// 좌표저장용 클래스
class Point {
    int r;
    int c;

    Point(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

class Solution {
    static char[][] map; // storage를 2차원 문자 배열로 변환
    static int n, m; // 행 열
    static int[] dr = {-1, 0, 1, 0}; // 상우하좌
    static int[] dc = {0, 1, 0, -1};

    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        n = storage.length;
        m = storage[0].length();
        map = new char[n][m];

        // 문자열 -> 문자로 변환하여 map 저장
        for (int i = 0; i < n; i++) {
            map[i] = storage[i].toCharArray();
        }

        for (int i = 0; i < requests.length; i++) {
            char c = requests[i].charAt(0);
            if (requests[i].length() == 1) removeOne(c);  // 지게차 요청
            else removeAll(c);                            // 크레인 요청
        }

        // 요청 처리 후 남아있는 물건 개수 세기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] != '.') answer++;
            }
        }

        return answer;
    }

    // 지게차 요청
    public void removeOne(char target) {
        List<Point> removePoint = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == target && (isOutside(i, j) || canEscape(i, j))) {
                    removePoint.add(new Point(i, j)); // 제거 대상 좌표 저장
                }
            }
        }

        // 실제로 제거 ('.'로 변경)
        for (Point point : removePoint) {
            map[point.r][point.c] = '.';
        }
    }

    // 외곽에 위치했으면 제거 가능하므로 확인
    public boolean isOutside(int r, int c) {
        return (r == 0 || r == n - 1 || c == 0 || c == m - 1);
    }

    // BFS로 '.' 경로를 따라 안쪽까지 도달 가능한지 확인
    public boolean canEscape(int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];

        queue.offer(new Point(r, c));
        visited[r][c] = true;

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            for (int d = 0; d < 4; d++) {
                int nr = point.r + dr[d];
                int nc = point.c + dc[d];

                // 범위 벗어나면 탈출 가능
                if (nr < 0 || nr >= n || nc < 0 || nc >= m) return true;

                // 방문하지 않았고 빈 칸('.')이면 계속 탐색
                if (!visited[nr][nc] && map[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    queue.offer(new Point(nr, nc));
                }
            }
        }

        // 탈출 불가능
        return false;
    }

    // 크레인 요청: 해당 문자를 모두 제거
    public void removeAll(char target) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == target) map[i][j] = '.';
            }
        }
    }
}

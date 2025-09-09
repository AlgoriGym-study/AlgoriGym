package Algorithm_Study.common.C202509.C20250910;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class SJG0043 {
    static int N, M;
    static int[][] grid;
    
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    static class Point {
        int r, c, dist;
        boolean destroyed;

        public Point(int r, int c, int dist, boolean destroyed) {
            this.r = r;
            this.c = c;
            this.dist = dist;
            this.destroyed = destroyed;
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < M; j++) {
                grid[i][j] = line.charAt(j) - '0';
            }
        } // 입력 완료
        
        System.out.print(bfs());
        br.close();
    }
    
    private static int bfs() {
        Deque<Point> dq = new ArrayDeque<>();
        boolean[][][] visited = new boolean[N][M][2];
        visited[0][0][0] = true;
        dq.offer(new Point(0, 0, 1, false));
        
        while(!dq.isEmpty()) {
            Point curr = dq.poll();
            int r = curr.r;
            int c = curr.c;
            int dist = curr.dist;
            boolean destroy = curr.destroyed;
            
            if(r == N - 1 && c == M - 1) return dist;
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= M) continue;
                // 다음 칸의 벽이 0일 때
                if (grid[nr][nc] == 0) {
                    int destroyedState = destroy ? 1 : 0; // 현재 파괴 상태 (0 또는 1)
                    // 현재 상태 그대로 다음 칸을 방문한 적 없다면
                    if (!visited[nr][nc][destroyedState]) {
                        visited[nr][nc][destroyedState] = true;
                        dq.offer(new Point(nr, nc, dist + 1, destroy));
                    }
                }
                // 다음 칸이 벽이 1일 때
                else {
                    // grid[nr][nc] == 1
                    // 아직 벽을 부순 적이 없고 && '벽을 부순 상태'로 다음 칸을 방문한 적 없다면
                    if (!destroy && !visited[nr][nc][1]) {
                        visited[nr][nc][1] = true; // '벽 부순 상태'로 방문 처리
                        dq.offer(new Point(nr, nc, dist + 1, true));
                    }
                }
            }
        }
        
        return -1;
    }
}

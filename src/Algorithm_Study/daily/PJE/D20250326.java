package Algorithm_Study.daily.PJE;
import java.util.*;
// SWEA 파핑파핑 지뢰찾기
public class D20250326 {
    
	static int N;
    static char[][] map;
    static int[][] numMap;
    static boolean[][] visited;
    
    static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) {
    
    	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            map = new char[N][N];
            numMap = new int[N][N];
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                String str = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j);
                }
            }

            // 지뢰 찾아서 지도에 숫자 채우기 
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '*') continue;
                    int count = 0;
                    for (int d = 0; d < 8; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                        if ((nr >= 0 && nc >= 0 && nr < N && nc < N )&& map[nr][nc] == '*') count++;
                    }
                    numMap[i][j] = count;
                }
            }

            // 최소 클릭 수 찾기 위해 0인 칸들 먼저 클릭
            int clicks = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && numMap[i][j] == 0 && !visited[i][j]) {
                        bfs(i, j);
                        clicks++;
                    }
                }
            }

            // 0인 칸 다 누르고 나면 나머지 칸들 개별 클릭
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == '.' && !visited[i][j]) {
                        clicks++;
                    }
                }
            }

            System.out.println("#" + tc + " " + clicks);
        }
    }

    static void bfs(int r, int c) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int cr = now[0];
            int cc = now[1];

            if (numMap[cr][cc] != 0) continue;

            for (int d = 0; d < 8; d++) {
                int nr = cr + dr[d];
                int nc = cc + dc[d];
                if ((nr >= 0 && nc >= 0 && nr < N && nc < N ) && map[nr][nc] == '.' && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }

}

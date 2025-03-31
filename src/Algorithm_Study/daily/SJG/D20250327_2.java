package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D20250327_2 {
	static int n, m, goalSpotX, goalSpotY;
    static int[][] field;
    static int[][] distance;
    static boolean[][] visited;
    static StringBuilder sb;
    
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        
        String[] inputNM = br.readLine().split(" ");
        n = Integer.parseInt(inputNM[0]);
        m = Integer.parseInt(inputNM[1]);
        
        field = new int[n][m];
        distance = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            for(int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(input[j]);
                if(field[i][j] == 2) {
                    goalSpotX = i;
                    goalSpotY = j;
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) distance[i][j] = -1;
        }
        
        bfs(goalSpotX, goalSpotY);
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if (field[i][j] == 0) {
                    sb.append(0).append(" ");
                } else {
                    sb.append(distance[i][j]).append(" ");   
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    
    private static void bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startR, startC});
        visited[startR][startC] = true;
        distance[startR][startC] = 0;
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                
                if(isValid(nr, nc) &&  !visited[nr][nc] && field[nr][nc] != 0) {
                    visited[nr][nc] = true;
                    distance[nr][nc] = distance[r][c] + 1;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
    
    private static boolean isValid(int r, int c) {
        if(r < 0 || c < 0 || r >= n || c >= m) return false;
        return true;
    }
}

package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250404 {
  static int N, M;
  static int[][] map;
  static int[][] days;
  static int ans;
  static int[] dr, dc;
    
  public static void main(String[] args) throws Exception {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      StringBuilder sb = new StringBuilder();
        
      dr = new int[] {-1, 1, 0, 0};
      dc = new int[] {0, 0, -1, 1};
        
      String[] inputMN = br.readLine().split(" ");
      M = Integer.parseInt(inputMN[0]);
      N = Integer.parseInt(inputMN[1]);
      Queue<int[]> q = new LinkedList<>();
        
      map = new int[N][M];
      days = new int[N][M];
      int cnt = 0;
        
      for(int i = 0; i < N; i++) {
          String[] input = br.readLine().split(" ");
          for(int j = 0; j < M; j++) {
              map[i][j] = Integer.parseInt(input[j]);
              days[i][j] = -1;
              if(map[i][j] == 1) {
                  days[i][j] = 0;
                  q.offer(new int[]{i, j});
              } else if(map[i][j] == 0) {
                  cnt++;
              }
          }
      }    // 입력 끝
      if(cnt == 0) {
          System.out.print(0);
          br.close();
            return;
      }
        
      int result = bfs(q, cnt);
      System.out.print(result);
      br.close();
  }
    
  private static int bfs(Queue<int[]> q, int count) {
      int maxDays = 0;
        
      while(!q.isEmpty()) {
          int[] curr = q.poll();
          int r = curr[0];
          int c = curr[1];

          maxDays = maxDays > days[r][c] ? maxDays : days[r][c];
            
          for(int d = 0; d < 4; d++) {
              int nr = r + dr[d];
              int nc = c + dc[d];
                
              if (nr >= 0 && nr < N && nc >= 0 && nc < M && map[nr][nc] == 0 && days[nr][nc] == -1) {
                   days[nr][nc] = days[r][c] + 1;
                   q.offer(new int[]{nr, nc});
                   count--; 
              }
          }
      }
      return count == 0 ? maxDays : -1;
  }
}

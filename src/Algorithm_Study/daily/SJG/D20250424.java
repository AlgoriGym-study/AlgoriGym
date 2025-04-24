package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class D20250424 {
  static int N, M;
  static int[][] map;
  static boolean[][] visited;
    
  static int[] dr = new int[] {1, -1, 0, 0};
  static int[] dc = new int[] {0, 0, -1, 1};

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputNM = br.readLine().split(" ");
    N = Integer.parseInt(inputNM[0]);
    M = Integer.parseInt(inputNM[1]);
        
    map = new int[N][M];
    for(int i = 0; i < N; i++) {
      String[] input = br.readLine().split(" ");
      for(int j = 0; j < M; j++) map[i][j] = Integer.parseInt(input[j]);
    }    // 입력 끝
        
    int time = 0;
    while(true) {
      visited = new boolean[N][M];
      bfs(0, 0); // 외부공기 탐색

      List<int[]> toMelt = new ArrayList<>();
    
      for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
          if (map[i][j] == 1) {
            int airCount = 0;
            for (int d = 0; d < 4; d++) {
              int ni = i + dr[d];
              int nj = j + dc[d];
              if (ni < 0 || nj < 0 || ni >= N || nj >= M) continue;
              if (visited[ni][nj] && map[ni][nj] == 0) airCount++;
            }
            if (airCount >= 2) toMelt.add(new int[] { i, j });
          }
        }
      }

      if (toMelt.isEmpty()) break; // 녹일 게 없으면 종료

      for (int[] pos : toMelt) {
        map[pos[0]][pos[1]] = 0;
      }
      time++;
    }
    System.out.print(time);
  }
    
  private static void bfs(int startR, int startC) {
    Queue<int[]> q = new LinkedList<>();
    q.offer(new int[]{startR, startC});
    visited[startR][startC] = true;
        
    while(!q.isEmpty()) {
      int[] curr = q.poll();
      int r = curr[0];
      int c = curr[1];

      for (int d = 0; d < 4; d++) {
        int nr = r + dr[d];
        int nc = c + dc[d];

        if(nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || map[nr][nc] == 1) continue;
        visited[nr][nc] = true;
        q.offer(new int[]{nr, nc});
      }
    }
  }
}

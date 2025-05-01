package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D20250422 {
  static int N, M;
    static int[][] map, tmpMap;
    static int maxSafeArea = 0;
    
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    
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

        // 벽 세우기
        buildWall(0);
        
        System.out.print(maxSafeArea);
    }
    
    private static void buildWall(int count) {
        if(count == 3) {
            // 바이러스 퍼뜨리기
            bfs();
            return;
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    buildWall(count+1);
                    map[i][j] = 0;
                }
            }
        }
    }
    
    private static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        
        tmpMap = new int[N][M];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) tmpMap[i][j] = map[i][j];
        }
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tmpMap[i][j] == 2) q.offer(new int[]{i, j});
            }
        }
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= M || tmpMap[nr][nc] != 0) continue;
                
                tmpMap[nr][nc] = 2;
                q.offer(new int[]{nr, nc});
            }
        }
        
        countSafeArea();
    }
    
    private static void countSafeArea() {
        int count = 0;
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(tmpMap[i][j] == 0) count++;
            }
        }
        maxSafeArea = maxSafeArea > count ? maxSafeArea : count;
    }
}

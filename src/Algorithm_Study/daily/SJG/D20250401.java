package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class D20250401 {
  static int M, N, K;
    static int[][] field;
    static boolean[][] visited;
    
    static int[] dr, dc;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        dr = new int[] {-1, 1, 0, 0};
        dc = new int[] {0, 0, -1, 1};
        
        for(int tc = 0; tc < T; tc++) {
            String[] inputMNK = br.readLine().split(" ");
            M = Integer.parseInt(inputMNK[0]);
            N = Integer.parseInt(inputMNK[1]);
            K = Integer.parseInt(inputMNK[2]);
            
            int cnt = 0;
            field = new int[N][M];
            visited = new boolean[N][M];
            
            for(int i = 0; i < K; i++) {
                String[] input = br.readLine().split(" ");
                int c = Integer.parseInt(input[0]);
                int r = Integer.parseInt(input[1]);
                
                field[r][c] = 1;
            }    // 입력
            
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(field[i][j] == 1 && !visited[i][j]) {
                        cnt++;
                        bfs(i, j);
                    }
                }
            }
            
            sb.append(cnt).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
    
    private static void bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        visited[startR][startC] = true;
        q.offer(new int[]{startR, startC});
        
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nc < 0 || nr < 0 || nc >= M || nr >= N || visited[nr][nc] || field[nr][nc] == 0) continue;
                visited[nr][nc]= true;
                q.offer(new int[]{nr, nc});
            }
        }
    }
}

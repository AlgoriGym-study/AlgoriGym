package Algorithm_Study.common.C202507.C20250730;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SJG0036_2 {
    static int N, M;
    static int[][] field;
    static boolean[][] visited;
    static int max = Integer.MIN_VALUE;
    
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        field = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        // 모든 위치에서 탐색 시작
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, field[i][j], 1);  // DFS로 I, O, S, L 모양 처리
                visited[i][j] = false;
                
                checkT(i, j);  // T자 모양 별도 처리
            }
        }
        
        System.out.println(max);
    }
    
    // DFS로 4개 연결된 테트로미노 탐색 (T자 제외)
    static void dfs(int row, int col, int sum, int count) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            
            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) {
                continue;
            }
            
            visited[nr][nc] = true;
            dfs(nr, nc, sum + field[nr][nc], count + 1);
            visited[nr][nc] = false;  // 백트래킹
        }
    }
    
    // T자 모양 별도 처리
    static void checkT(int row, int col) {
        // 4가지 T자 모양 확인
        int[][] tShapes = {
            {1, 2, 3},  // ㅗ 모양 (아래쪽이 중심)
            {0, 2, 3},  // ㅜ 모양 (위쪽이 중심)  
            {0, 1, 3},  // ㅏ 모양 (왼쪽이 중심)
            {0, 1, 2}   // ㅓ 모양 (오른쪽이 중심)
        };
        
        for (int[] shape : tShapes) {
            int sum = field[row][col];  // 중심값
            boolean valid = true;
            
            // 3개 방향으로 뻗어나가는 T자 확인
            for (int dir : shape) {
                int nr = row + dr[dir];
                int nc = col + dc[dir];
                
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) {
                    valid = false;
                    break;
                }
                sum += field[nr][nc];
            }
            
            if (valid) {
                max = Math.max(max, sum);
            }
        }
    }
}

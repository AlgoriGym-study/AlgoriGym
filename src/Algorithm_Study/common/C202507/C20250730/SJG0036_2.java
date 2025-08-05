package Algorithm_Study.common.C202507.C20250730;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SJG0036_2 {
    static int N, M, maxSum;
    static int[][] board;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new int[N][M];
        visited = new boolean[N][M];
        
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        maxSum = 0;
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, board[i][j]);
                visited[i][j] = false;
                
                checkTShape(i, j); // T자 모양 별도 체크
            }
        }
        
        System.out.println(maxSum);
    }
    
    // DFS로 4칸 연결된 모양 찾기 (T자 제외)
    static void dfs(int x, int y, int depth, int sum) {
        if(depth == 4) {
            maxSum = Math.max(maxSum, sum);
            return;
        }
        
        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            
            if(nx < 0 || nx >= N || ny < 0 || ny >= M || visited[nx][ny]) {
                continue;
            }
            
            visited[nx][ny] = true;
            dfs(nx, ny, depth + 1, sum + board[nx][ny]);
            visited[nx][ny] = false;
        }
    }
    
    // T자 모양 체크
    static void checkTShape(int x, int y) {
        // T자의 4가지 형태
        int[][][] tShapes = {
            {{0,0},{0,1},{0,2},{1,1}}, // ㅗ
            {{0,0},{1,0},{2,0},{1,1}}, // ㅓ
            {{0,1},{1,0},{1,1},{1,2}}, // ㅜ
            {{0,1},{1,0},{1,1},{2,1}}  // ㅏ
        };
        
        for(int[][] shape : tShapes) {
            int sum = 0;
            boolean valid = true;
            
            for(int[] pos : shape) {
                int nx = x + pos[0];
                int ny = y + pos[1];
                
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    valid = false;
                    break;
                }
                sum += board[nx][ny];
            }
            
            if(valid) {
                maxSum = Math.max(maxSum, sum);
            }
        }
    }
}

package Algorithm_Study.common.C202507.C20250716;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SJG0032_2 {
    static int N;
    static int[][] grid;
    static int[][][] memo;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        grid = new int[N][N];
        memo = new int[N][N][3];
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(input[j]);
            }
        }
        
        // 메모이제이션 초기화
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < 3; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        
        int result = dfs(N-1, N-1, 0) + dfs(N-1, N-1, 1) + dfs(N-1, N-1, 2);
        System.out.print(result);
        br.close();
    }
    
    static int dfs(int r, int c, int dir) {
        // 범위 체크
        if (r < 0 || c < 0 || grid[r][c] == 1) return 0;
        
        // 시작점 도달
        if (r == 0 && c == 1 && dir == 0) return 1;
        if ((r == 0 && c == 1 && dir != 0) || (r < 0 || c < 1)) return 0;
        
        // 메모이제이션 체크
        if (memo[r][c][dir] != -1) return memo[r][c][dir];
        
        int result = 0;
        
        if (dir == 0) { // 현재 가로 방향
            result += dfs(r, c-1, 0); // 이전에 가로
            result += dfs(r, c-1, 2); // 이전에 대각선
        } else if (dir == 1) { // 현재 세로 방향
            result += dfs(r-1, c, 1); // 이전에 세로
            result += dfs(r-1, c, 2); // 이전에 대각선
        } else { // 현재 대각선 방향
            if (grid[r-1][c] == 0 && grid[r][c-1] == 0) {
                result += dfs(r-1, c-1, 0); // 이전에 가로
                result += dfs(r-1, c-1, 1); // 이전에 세로
                result += dfs(r-1, c-1, 2); // 이전에 대각선
            }
        }
        
        return memo[r][c][dir] = result;
    }
}

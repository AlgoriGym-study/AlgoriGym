package Algorithm_Study.common.C202509.C20250917;
import java.util.*;

public class PJE0044 {
    static int R, C;
    static int answer = 1;
    static boolean [] used = new boolean [26];
    static char [][] board; 
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        R = sc.nextInt();
        C = sc.nextInt();
    
        board = new char[R][C];
        for (int i = 0; i < R; i++) {
            String line = sc.next();       
            for (int j = 0; j < C; j++) {
                board[i][j] = line.charAt(j);
            }
        }
        used[board[0][0]-'A'] = true; // 첫번째 칸 방문처리
        dfs(0,0,1); // dfs 시작
        System.out.println(answer);
        
        
    }
    static void dfs(int r, int c, int depth){
        // 종료 조건
        answer = Math.max(answer, depth);
        if (answer == 26) return;
        
        // 재귀 조건
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            
            if(nr < 0 || nc < 0 || nr >= R || nc >= C )
                continue;
            
            int idx = board[nr][nc] - 'A';
            if (used[idx]) 
                continue;
            
            used[idx] = true;
            dfs(nr, nc, depth + 1);
            used[idx] = false; // 백트래킹
        }
    }
}

package Algorithm_Study.common.C202509.C20250917;
import java.util.*;
// 백준 알파벳 복습
public class PJE0044_2{
    static int R, C;
    static int answer = 1;
    static char [][] board;
    static boolean [] used = new boolean[26];
    static int [] dr = {-1,1,0,0};
    static int [] dc = {0,0,-1,1};
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();
        
        board = new char[R][C];
        for(int i = 0; i <R; i++){
            String str = sc.next();
            for(int j = 0; j < C; j++){
                board[i][j] = str.charAt(j);
            }
        }
        
        used[board[0][0]-'A'] = true;
        dfs(0,0,1);
        System.out.println(answer);
        
    }
    
    static void dfs(int r, int c, int depth){
        //종료
        answer = Math.max(answer, depth);
        
        //재귀
        for(int d = 0; d < 4; d++){
            int nr = r + dr[d];
            int nc = c + dc[d];
            if(nr < 0 || nc < 0 || nr >= R || nc >= C) // 범위 밖이면
                continue;
            if(used[board[nr][nc]-'A']) // 이미 지나간 알파벳이면
                continue;
            
            used[board[nr][nc] - 'A'] = true;
            dfs(nr, nc , depth + 1);
            used[board[nr][nc]-'A'] = false;
         }
    }
}

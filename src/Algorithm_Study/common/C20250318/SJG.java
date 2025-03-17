package Algorithm_Study.common.C20250318;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SJG {
	static int N;
    static int cnt = 0;
    static int[] col;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int test_case = 1; test_case <= T; test_case++) {
            cnt = 0;
            N = Integer.parseInt(br.readLine());
            col = new int[N];
        
        	perm(0);
            sb.append("#").append(test_case).append(" ").append(cnt).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
    
    private static void perm(int row) {
        if(row == N) {
            cnt++;
            return;
        }
        
        for(int i = 0; i < N; i++) {
            col[row] = i;
            
            if(isPossible(row)) perm(row+1);
        }
    }
    
    private static boolean isPossible(int row) {
        for(int i = 0; i < row; i++) {
            if(col[i] == col[row]) return false;
            if(Math.abs(row - i) == Math.abs(col[row] - col[i])) return false;
        }
        return true;
    }
}

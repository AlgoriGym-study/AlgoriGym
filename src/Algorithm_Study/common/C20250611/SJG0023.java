package Algorithm_Study.common.C20250611;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SJG0023 {
    public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            
            int[] dr = new int[] {0, 1, 0, -1};	// 우, 하, 좌, 상
           	int[] dc = new int[] {1, 0, -1, 0};
            
            int idx = 0;
            int r = 0;
            int c = 0;
            
            for(int i = 1; i <= N*N; i++) {
                arr[r][c] = i;
                
                int nr = r + dr[idx];
                int nc = c + dc[idx];
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= N || arr[nr][nc] != 0) {
                    idx = ++idx % 4;
                    nr = r + dr[idx];
                    nc = c + dc[idx];
                }
                
                r = nr;
                c = nc;
            }
            
            sb.append("#").append(test_case).append("\n");
        	for(int i = 0; i < N; i++) {
            	for(int j = 0; j < N; j++) sb.append(arr[i][j]).append(" ");
            	sb.append("\n");
        	}
		}
        System.out.print(sb);
        br.close();
	}
}

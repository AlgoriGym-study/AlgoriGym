package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

class D20250412
{
    static int N, startR, startC, endR, endC, res;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr, dc;
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        N = 16;
        
        dr = new int[]{-1, 1, 0, 0};
        dc = new int[]{0, 0, -1, 1};

		for(int test_case = 1; test_case <= T; test_case++)
		{
			br.readLine();
            map = new int[N][N];
            visited = new boolean[N][N];
            res = 0;
            
            for(int i = 0; i < N; i++) {
                char[] input = br.readLine().toCharArray();
                for(int j = 0; j < N; j++) {
                    map[i][j] = input[j] - '0';
                    // 출발점, 도착점 셋팅
                    if(map[i][j] == 2) {
                        startR = i;
                        startC = j;
                    } else if(map[i][j] == 3) {
                        endR = i;
                        endC = j;
                	}
            	}
			} // 입력 완료
            bfs(startR, startC);
            sb.append("#").append(test_case).append(" ").append(res).append("\n");
		}
        System.out.print(sb);
        br.close();
    }
    
    private static void bfs(int startR, int startC) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startR, startC});
        visited[startR][startC] = true;
        boolean check = false;
        
		while(!q.isEmpty()) {
            int[] curr = q.poll();
            int r = curr[0];
            int c = curr[1];
            
            for(int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc] || map[nr][nc] == 1) continue;
                if(nr == endR && nc == endC) {
                    res = 1;
                    check = true;
                    break;
                } else {
                    visited[nr][nc] = true;
	                q.offer(new int[]{nr, nc});
                }
            }
            if(check) break;
        }
    }
}
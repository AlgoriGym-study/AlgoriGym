package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250331 {
	static int N;
    static int[][] map;
    static int maxDessert;
     
    static int[] dr, dc;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        // 우하, 좌하, 좌상, 우상
        dr = new int[]{1, 1, -1, -1};
        dc = new int[]{1, -1, -1, 1};
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            maxDessert = -1;
             
            for(int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                for(int j = 0; j < N; j++) map[i][j] = Integer.parseInt(input[j]);
            }
             
            for(int i = 0; i < N; i++) {
                for(int j = 0; j  <N; j++) {
                    boolean[] visited = new boolean[101];
                     
                    visited[map[i][j]] = true;
                    dfs(i, j, i, j, 0, 0, 1, visited);
                }
            }
 
            sb.append("#").append(test_case).append(" ").append(maxDessert).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
     
    private static void dfs(int r, int c, int startR, int  startC, int dir, int turnCnt, int count, boolean[] visited) {
         
        // 탐색방향은 직진 또는 우회전 -> 0: 직진, 1: 우회전 시도
        for(int i = 0; i < 2; i++) {
             
            int nextDir = dir + i;  // 0혹은 1을 더해줌
             
            // 사각형을 그려야하기 때문에 turnCnt는 3번만 가능
            if(nextDir >= 4) continue;
            int nextTurnCnt = (i == 1) ? turnCnt + 1: turnCnt;
            if(nextTurnCnt > 3) continue;
             
            int nr = r + dr[nextDir];
            int nc = c + dc[nextDir];
             
            // 출발점 돌아왔을 때
            if(nr == startR && nc == startC && nextTurnCnt == 3 && count >= 3) {
                maxDessert = Math.max(maxDessert, count);
                return;
            }
             
            if(nr < 0 || nc < 0 || nr >= N || nc >= N || visited[map[nr][nc]]) continue;
             
            visited[map[nr][nc]] = true;
            dfs(nr, nc, startR, startC, nextDir, nextTurnCnt, count+1, visited);
            visited[map[nr][nc]] = false;
        }
    }
}

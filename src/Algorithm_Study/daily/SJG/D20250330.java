package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250330 {
	static int N;
    static char[][] field;
    static int[][] counts;
    static boolean[][] visited;
     
    static int[] dr, dc;
     
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
         
        // 상, 하, 좌, 우, 좌상, 우상, 좌하, 우하
        dr = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
        dc = new int[]{0, 0, -1, 1, -1, 1, -1, 1};
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            N = Integer.parseInt(br.readLine());
            field = new char[N][N];
            visited = new boolean[N][N];
            counts = new int[N][N];
            for(int i = 0; i < N; i++) {
                char[] input = br.readLine().toCharArray();
                for(int j = 0; j < N; j++) field[i][j] = input[j];
            }
             
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    // 지뢰일때
                    if(field[i][j] == '*') {
                        counts[i][j] = -1;
                        continue;
                    }
                    int mineCnt = 0;
                    for(int d= 0; d < 8; d++) {
                        int nr = i + dr[d];
                        int nc = j + dc[d];
                         
                        if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                         
                        if(field[nr][nc] == '*') mineCnt++;
                    }
                    counts[i][j] = mineCnt;
                }
            }
            int clickCnt = 0;
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(field[i][j] == '.' && counts[i][j] == 0 && !visited[i][j]) {
                        clickCnt++;
                        bfs(i, j);
                    }
                }
            }
             
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(field[i][j] == '.' && !visited[i][j]) clickCnt++;
                }
            }
            sb.append("#").append(test_case).append(" ").append(clickCnt).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
     
    private static void bfs(int r , int c) {
        Queue<int[]> q = new LinkedList<>();
        visited[r][c] = true;
        q.offer(new int[]{r, c});
         
        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int currR = curr[0];
            int currC = curr[1];
             
            for(int d = 0; d < 8; d++) {
                int nr = currR + dr[d];
                int nc = currC + dc[d];
                 
                if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
                if(visited[nr][nc] || field[nr][nc] == '*') continue;
                 
                visited[nr][nc] = true;
                if(counts[nr][nc] == 0) {   
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}

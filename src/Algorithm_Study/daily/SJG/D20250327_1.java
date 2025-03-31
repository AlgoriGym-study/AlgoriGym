package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class D20250327_1 {
	static int N;
    static int[][] arr;
    static boolean[][] visited;
    static int cnt;
    
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        visited = new boolean[N][N];
        List<Integer> cntList = new ArrayList<>();
        cnt = 1;
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < N; j++) {
            	arr[i][j] = input.charAt(j) - '0';
            	if(arr[i][j] == 0) visited[i][j] = true;
            }
        }
        br.close();
        
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!visited[i][j]) {
                    dfs(i, j);
                    cntList.add(cnt);
                }
                cnt = 1;
            }
        }
        sb.append(cntList.size()).append("\n");
        Collections.sort(cntList);
        for(int n : cntList) sb.append(n).append("\n");
        
        System.out.print(sb);
    }
    private static void dfs(int r, int c) {
        visited[r][c] = true;
            
        for(int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d];
                
            if(nr < 0 || nc < 0 || nr >= N || nc >= N) continue;
            if(visited[nr][nc]) continue;
            cnt++;
            dfs(nr, nc);
        }
    }
}

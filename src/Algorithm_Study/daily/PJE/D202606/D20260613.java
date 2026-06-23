package Algorithm_Study.daily.PJE.D202606;
import java.util.*;
public class D20260613 {
      public int solution(int[][] maps) {
        int [] dx = {-1,1,0,0};
        int [] dy = {0,0,-1,1};
    
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length;
        boolean [][] visited = new boolean[n][m];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int []{0,0,1});
         
        
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            if(x == n-1 && y == m-1){
                return dist;
            }
            
            for(int i = 0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                
                if( (0<=nx && nx<n) && (0<=ny && ny<m) && !visited[nx][ny] && maps[nx][ny]==1){
                    visited[nx][ny] = true;
                    q.offer(new int []{nx,ny,dist+1});
                }
            }
            
        }
        return -1;
    }
}

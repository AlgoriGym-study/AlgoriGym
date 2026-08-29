package Algorithm_Study.daily.PJE.D202606;
import java.util.*;
public class D20260627 {
    public int solution(int x, int y, int n) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[y + 1];
        queue.offer(new int []{x,0});
        visited[x] = true;
        while(!queue.isEmpty()){
            int[] now = queue.poll();
            int cur = now[0];
            int count = now[1];
            if(cur == y) return count;
            if(cur+n <= y && !visited[cur+n]) {
                visited[cur+n] = true;
                queue.offer(new int[] {cur+n,count+1});
            }
            if(cur*2 <= y && !visited[cur*2]){
                visited[cur*2] = true;
                queue.offer(new int[] {cur*2,count+1});  
            } 
            if(cur*3 <= y && !visited[cur*3]) {
                visited[cur*3] = true;
                queue.offer(new int[] {cur*3,count+1});
            }
        }
        return -1;
    }
}

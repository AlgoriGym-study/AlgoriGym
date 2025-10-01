package Algorithm_Study.common.C202509.C20250924;
import java.util.*;

public class PJE0046_2{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <=T; tc++ ){
            int N = sc.nextInt(); // 건물 수
            int K = sc.nextInt(); // 규칙 개수
            
            int [] time = new int[N+1];
            int[][] building = new int[N+1][N+1];
            int[] indegree = new int [N+1];
            int[] dist = new int[N+1];
            
            for(int i = 1; i <= N; i++){
                int S = sc.nextInt();
                time[i] = S;
            }
            
            for(int i = 1; i <= K; i++){
                int X = sc.nextInt(); //건설 순서
                int Y = sc.nextInt();
                
                building[X][Y] = 1;
                indegree[Y]++;
            }
            int W = sc.nextInt(); // 지어야할 건물 번호 
            Queue<Integer> q = new LinkedList<Integer>();
            for(int i = 0; i < indegree.length; i++){
                if(indegree[i] == 0){
                    dist[i] = time[i];
                    q.add(i);
                }
            }
            
            while(!q.isEmpty()){
                int n = q.poll();
                if(n==W) break;
                
                for(int to = 1; to <= N; to++){
                    if(building[n][to] ==1){
                        dist[to] = Math.max(dist[n] + time[to], dist[to]);
                        indegree[to]--;
                        
                        if(indegree[to] == 0){
                            q.add(to);
                        }
                    }
                }
            }
            System.out.println(dist[W]);
        }
    }
    
    
}

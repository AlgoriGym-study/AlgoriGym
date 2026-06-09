package Algorithm_Study.daily.PJE.D202606;
public class D20260607 {
    static int answer = 0; // 최대 던전수
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        boolean[] visited = new boolean[n]; // 방문 배열
        int[] output = new int[n]; // 인덱스 순서 담기
        
        //순열
        permutation(0,n,k,dungeons,output,visited);
        
        return answer;
    }
    
    public void permutation(int depth, int n, int k, int[][] dungeons, int[] output, boolean[] visited){
        if(depth==n){
            checkDungeons(k,dungeons,output);
            return;
        }
        for(int i = 0; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = i;
                
                permutation(depth+1,n,k,dungeons, output, visited);
                visited[i] = false; 
                
            }
        }
    }
    
    public void checkDungeons(int current, int[][] dungeons, int[] order){
        int count = 0;
        
        for(int idx : order){
            int minRequired = dungeons[idx][0]; 
            int consume = dungeons[idx][1]; // 소모 피로도
            
            // 현재 피로도가 최소 피로도 이상이면 탐험 가능
            if(current >= minRequired){
                current -= consume;
                count++;
            }else{
                break; // 피로도 부족하면 탐험 못함
            }
        }
        // 최대 던전 탐험수랑 비교해서 갱신
        answer = Math.max(answer, count); 
    }
    
}

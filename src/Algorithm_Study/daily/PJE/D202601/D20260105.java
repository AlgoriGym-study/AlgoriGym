package Algorithm_Study.daily.PJE.D202601;

public class D20260105 {
    public int[] solution(int[] lottos, int[] win_nums) {
        // lottos :  민우 로또  
        // win_nums : 당첨 번호 
        
        int[] answer = new int [2];
        // 맞은 개수에 따른 순위 배열
        int [] rank = {6,6,5,4,3,2,1};
        
        // 같은 수, 0의 개수 찾기 
        int zeros = 0;
        int hitCount = 0;
        
        for(int lotto : lottos){
            if(lotto == 0){
                zeros++;
                continue;
            }
                
            for(int win_num : win_nums){
                if(win_num == lotto){
                    hitCount++;
                    break;
                }
            }
        }
        
        
        // hitCount + zeros = 제일 많이 맞춤, 최고 순위
        // hitCount = 제일 적게 맞춤, 최저 순위
        answer[0] = rank[hitCount + zeros];
        answer[1] = rank[hitCount];
        
        return answer;
    }
}

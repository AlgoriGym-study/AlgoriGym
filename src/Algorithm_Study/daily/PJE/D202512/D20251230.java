package Algorithm_Study.daily.PJE.D202512;
public class D20251230 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        // lottos : 민우가 구매한 로또 번호 
        // win_nums : 당첨 번호를 담은 배열 
        // 최고, 최저 번호를 담아서 리턴
        int zeros = 0;
        int same = 0;
        for(int i = 0; i < lottos.length; i++){
            if(lottos[i] == 0){
                    zeros++;
            }
        }
        for(int i = 0; i < lottos.length; i++){
            for(int j = 0; j < lottos.length; j++){
                if(lottos[i] == win_nums[j]){
                    same++;
            }   
            } 
        }

        int max = (same+zeros == 0)? 6 : 7 - (same+zeros); //최고 순위
        int min = (same == 0) ? 6 : 7 - same; // 최저 순위
        answer[0] = max;
        answer[1] = min;
            
        return answer;
    }
}

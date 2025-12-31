package Algorithm_Study.daily.LYR.Dec2025;

import java.util.Arrays;

public class D20251230 {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {1,6};
        int[] nothing = {0,0,0,0,0,0};

        // 전체가 알아볼 수 없는 경우인지 검사
        if(Arrays.equals(lottos, nothing)){
            return answer;
        }

        //현재 해당하는 갯수
        int match = 0;
        int zero = 0;
        for(int num : lottos){
            if(num == 0){
                zero++;
                continue;
            }
            for(int win : win_nums){
                if(num == win){
                    match++;
                    break;
                }
            }
        }

        int maxLank = 7-(match+zero);
        if(match+zero == 0)
            maxLank = 6;
        int minLank = 7-match;
        if(match == 0)
            minLank = 6;
        answer[0] = maxLank;
        answer[1] = minLank;
        return answer;
    }
}

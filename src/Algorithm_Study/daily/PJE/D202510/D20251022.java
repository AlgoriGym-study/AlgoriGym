package Algorithm_Study.daily.PJE.D202510;
import java.util.*;
//프로그래머스 모의고사
public class D20251022 {
    public int[] solution(int[] answers) {
        
        int len = answers.length;
        int [] one = {1,2,3,4,5};
        int [] two = {2,1,2,3,2,4,2,5};
        int [] three = {3,3,1,1,2,2,4,4,5,5};
        int ans1 = 0, ans2=0, ans3 = 0;
        
        for(int i = 0; i < len; i++){
            int idx1 = i%5;
            int idx2 = i%8;
            int idx3 = i%10;
            
            if(one[idx1]==answers[i]){
                ans1++;
            }
            if(two[idx2]==answers[i]){
                ans2++;
            }
            if(three[idx3]==answers[i]){
                ans3++;
            }
          
        }
        List<Integer> list = new ArrayList<>();
        int max = Math.max(ans1,Math.max(ans2,ans3));
        if(ans1 == max)
          list.add(1);
        if(ans2 == max) 
            list.add(2);
        if(ans3 == max)
            list.add(3);
        
        int listLen = list.size();
        int[] answer = new int[listLen];
        for(int i =0; i<listLen; i++){
                answer[i] = list.get(i);
            }
        return answer;
    }
}

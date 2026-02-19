package Algorithm_Study.daily.PJE.D202602;
import java.util.*;
public class D20260219 {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        // rank에서 TRUE만 찾아서 인덱스와 요소를 맵으로 넣음
        // 요소를 기준으로 정렬
        Map <Integer, Integer> rankMap = new TreeMap<>();
        for(int i = 0; i< attendance.length; i++){
            if(attendance[i])
                rankMap.put(rank[i],i);
        }
        int cnt = 1;
        for(Integer i : rankMap.values()){
            switch(cnt){
                case 1 :
                    answer = 10000*i;
                    break;
                case 2 : 
                    answer = answer + 100*i;
                    break;
                case 3 :
                    answer = answer + i;
                    break;
                default:
                    break;
            }
            if(cnt > 3)
                break; 
            
            cnt++;
        }
        
        return answer;
    }
}

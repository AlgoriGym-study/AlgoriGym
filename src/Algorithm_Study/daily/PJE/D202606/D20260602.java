package Algorithm_Study.daily.PJE.D202606;
import java.util.*;
public class D20260602 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        // 각 아이템 맵에 저장
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < want.length; i++){
            map.put(want[i],number[i]);
        }
       
        // discount 항목 1번부터 각 10개만 확인하기 
        for(int i = 0; i <= discount.length-10; i++){
             
             // 비교할 맵 
             Map<String, Integer> discountMap = new HashMap<>();
            for(int j = i; j < i+10; j++){
                discountMap.put(discount[j],discountMap.getOrDefault(discount[j],0)+1);
            }
            // 두 맵 비교
            if(map.equals(discountMap)){
                answer++;
            }
        }
        return answer;
    }
}

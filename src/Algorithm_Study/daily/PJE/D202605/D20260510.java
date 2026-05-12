package Algorithm_Study.daily.PJE.D202605;
import java.util.*;
public class D20260510 {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        // 귤 크기별로 저장
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : tangerine){
            map.put(t, map.getOrDefault(t,0)+1);
        }
        // 개수만 따로 리스트 추출
        List<Integer> counts = new ArrayList<>(map.values());
        
        // 개수 많은 순서대로 내림차순
        Collections.sort(counts,Collections.reverseOrder());
        // 가장많은 종류부터 k 카운트
        for(int count : counts){
            k -= count;
            answer++;
            
            if(k<=0)
                break;
        }
    
        return answer;
    }
}

package Algorithm_Study.daily.PJE.D202606;
import java.util.*;
public class D20260614 {
    public int solution(int[] topping) {
        int answer = 0;
        Map<Integer,Integer> map = new HashMap<>();
        // 형이 모두 가지고 있다고 가정
        for(int t : topping){
            map.put(t, map.getOrDefault(t,0)+1);
        }
        
        Set<Integer> set = new HashSet<>();
        //동생에게 하나씩 건내준다고 가정
        for(int i = 0; i<topping.length-1;i++){
            //동생에게 하나 추가
            set.add(topping[i]);
            //형에게 하나 뺏기
            map.put(topping[i],map.get(topping[i])-1);
            
            //만약 해당 key의 값이 0이되면 아예 없애기
            if(map.get(topping[i])==0){
                map.remove(topping[i]);
            }
            
            // 그 다음 사이즈 비교
            if(set.size() == map.size()){
                answer++;
            }
        }
        return answer;
    }
}

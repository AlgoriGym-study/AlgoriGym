package Algorithm_Study.daily.PJE.D202606;
import java.util.*;
public class D20260623 {
    public int solution(int[] topping) {
        int answer = 0;
        //형이 모두 가지고 있다고 가정
        Map<Integer, Integer> map = new HashMap<>();
        for(int t : topping){
            map.put(t,map.getOrDefault(t,0)+1);
        }
        Set<Integer> set = new HashSet<>();
        //동생한테 하나씩 건네준다고 생각
        for(int i = 0; i < topping.length; i++){
            //동생에게 하나 줌 
            set.add(topping[i]);
            //형에게서 하나 제거 
            map.put(topping[i],map.get(topping[i])-1);
            //검색해서 0이면 아예 제거해버리기
            if(map.get(topping[i])==0){
                map.remove(topping[i]);
            }
            //각자 가진 토핑의 개수를 검색해서 수가 같으면 answer++
            if(map.size() == set.size()){
                answer++;
            }
        }
        return answer;
    }
}

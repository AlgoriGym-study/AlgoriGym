package Algorithm_Study.daily.PJE.D202601;
import java.util.*;
public class D20260122 {
    public int[] solution(int l, int r) {
       
        List<Integer> list = new ArrayList<>();
        for(int i = l; i <= r; i++){
            String str = (i+"").replace("5","").replace("0","");
            if(str.equals("")){
                list.add(i);
            }                
        }
        int [] answer = list.size() ==0 ? new int[]{-1} : list.stream().mapToInt(Integer::intValue).toArray();   
                
        return answer;
    }
}

package Algorithm_Study.daily.PJE.D202604;
import java.util.*;
    
public class D20260410 {
    public int[] solution(int[] arr, int divisor) {
        
    List<Integer> list = new ArrayList<>();
    
    for (int num : arr) {
        if (num % divisor == 0) {
            list.add(num);
        }
    }
    
    
    if (list.isEmpty()) {
        return new int[]{-1};
    }
    
    // 오름차순정렬
    Collections.sort(list);
    
    int[] answer = new int[list.size()];
    for (int i = 0; i < list.size(); i++) {
        answer[i] = list.get(i);
    }
    
    return answer;
    }
}

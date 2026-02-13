package Algorithm_Study.daily.PJE.D202602;
import java.util.*;
public class D20260213 {
    public int[] solution(int[] prices) {
        // 요소 하나에 대해서 그 다음 요소 중 더 작은 요소가 있으면 해당 요소까지의 거리를 answer 에 담기
        int[] answer = new int [prices.length];  // 정답배열
        for(int i = prices.length-1,idx = 0; i >= 0; i--){
            answer[idx++] = i;
        }
        
        Stack<Integer> stk = new Stack<>();  // 인덱스 
        for(int i = 0; i < prices.length; i++){
            while(!stk.isEmpty() && prices[stk.peek()] > prices[i]){
                int idx = stk.pop();
                answer[idx] = i-idx;
            }
            stk.push(i);
        }
        return answer;
    }
}

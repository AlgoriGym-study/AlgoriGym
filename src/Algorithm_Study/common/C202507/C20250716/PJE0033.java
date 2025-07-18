package Algorithm_Study.common.C202507.C20250716;
import java.util.*;

// 프로그래머스 프로세스
class PJE0033 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int priority : priorities){
            pq.add(priority);
        }
        
        while(!pq.isEmpty()){
            for(int i = 0; i<priorities.length; i++){
                if(priorities[i] == pq.peek()){
                    pq.poll();
                    answer++;
                    if(i==location){
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}

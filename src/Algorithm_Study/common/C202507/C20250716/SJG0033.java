package Algorithm_Study.common.C202507.C20250716;

import java.util.PriorityQueue;

public class SJG0033 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>((n1, n2) -> {
            return n2 - n1;
        });
        for(int prior : priorities) queue.offer(prior);
        
        while(!queue.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (queue.peek() == priorities[i]){
                    queue.poll();
                    answer++;
                    
                    if(location == i) {
                        return answer;
                    }
                }
            }
        }
        return answer;
    }
}

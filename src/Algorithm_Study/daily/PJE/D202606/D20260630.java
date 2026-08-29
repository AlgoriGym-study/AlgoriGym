package Algorithm_Study.daily.PJE.D202606;

import java.util.*;
class D20260630 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        Queue<Integer> queue = new PriorityQueue<>();
        for(int s : scoville){
            queue.offer(s);
        }
        while(true){
            
            // 가장 작은 지수가 K이상이면 끝
            int smallest = queue.poll();
            if(smallest >= K) break;
            // 아니면 음식 섞기
            if(queue.isEmpty()) return -1;
            int second = queue.poll();
            int mixed = smallest + second*2;
            // 섞은 개수 업데이트 
            answer++;
            // queue 업데이트
            queue.offer(mixed);
        }
        // while(!queue.isEmpty()){
        //     System.out.println(queue.poll());
        // }
        
        return answer;
    }
}

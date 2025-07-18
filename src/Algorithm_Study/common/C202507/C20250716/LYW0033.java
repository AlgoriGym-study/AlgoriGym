package Algorithm_Study.common.C202507.C20250716;

import java.util.*;

public class LYW0033 {
    public int solution(int[] priorities, int location) {
        
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i = 0; i < priorities.length; i++){
            queue.offer(new int[] {i, priorities[i]});
        }
        
        int cnt = 0;
        
        // queue에서 poll한 값의 우선순위 비교
        while(!queue.isEmpty()){
            int[] current = queue.poll();
            
            boolean hasHigher = false;
            for(int[] q : queue){
                if(q[1] > current[1]){
                    hasHigher = true;
                    break;
                }
            }
            // 우선순위가 더 높은게 있는 경우 queue에 다시 넣는다
            if(hasHigher) {
                queue.offer(current);
            }
            // 현재 우선순위가 제일 높은 경우 cnt++
            else {
                cnt++;
                if(current[0] == location){
                    return cnt;
                }
            }
        }
        
        return -1;
    }
}

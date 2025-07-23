package Algorithm_Study.common.C202507.C20250716;

public class SJG0033_2 {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int[] arr = priorities.clone();
        
        while(true) {
            int maxPriority = getMaxPriority(arr);
            
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] == maxPriority) {
                    arr[i] = 0; // 처리된 작업은 0으로 표시
                    answer++;
                    
                    if(i == location) {
                        return answer;
                    }
                    break;
                }
            }
        }
    }
    
    private int getMaxPriority(int[] arr) {
        int max = 0;
        for(int priority : arr) {
            max = Math.max(max, priority);
        }
        return max;
    }
}

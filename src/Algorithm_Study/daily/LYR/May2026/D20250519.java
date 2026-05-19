package Algorithm_Study.daily.LYR.May2026;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D20250519 {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(n >= a){
            answer += n/a*b;
            n = n - (n/a)*a + (n/a)*b;
        }
        return answer;
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for(int x = 0;x<commands.length;x++){
            int[] arr = new int[commands[x][1] - commands[x][0] + 1];
            int idx = 0;
            for(int i=commands[x][0]-1;i<=commands[x][1]-1;i++){
                arr[idx] = array[i];
                idx++;
            }
            Arrays.sort(arr);
            answer[x] = arr[commands[x][2]-1];
        }
        return answer;
    }

    public int solution(int[] nums) {
        int answer = 0;
        Map<Integer, Integer> type = new HashMap<>();
        for(int n : nums){
            if(type.get(n) == null)
                type.put(n, 1);
            else
                continue;
        }
        for(int key : type.keySet())
            answer++;
        if(answer > nums.length/2)
            answer = nums.length/2;
        return answer;
    }
}

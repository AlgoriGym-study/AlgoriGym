package Algorithm_Study.daily.LYR.May2026;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class D20260508 {
    public int[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = new int[set.size()];
        int idx = 0;
        for(int s : set){
            answer[idx] = s;
            idx++;
        }
        Arrays.sort(answer);
        return answer;
    }
}

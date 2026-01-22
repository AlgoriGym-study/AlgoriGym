package Algorithm_Study.daily.LYR.Jan2026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class D20260121 {
    public int[] solution(int[] arr, int divisor) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(arr);
        for(int num : arr){
            if(num % divisor == 0)
                list.add(num);
        }
        if(list.isEmpty())
            return new int[]{-1};
        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }
}

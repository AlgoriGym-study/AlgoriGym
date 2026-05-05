package Algorithm_Study.daily.PJE.D202605;
import java.util.*;
public class D20260505 {
    public int solution(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for(int num: nums){
          set.add(num);
        }
        int pocketLen = nums.length/2;
        int maxLen = set.size();
        if(pocketLen >= maxLen){
            answer = maxLen;
        }else{
            answer = pocketLen;
        }
        return answer;
    }
}

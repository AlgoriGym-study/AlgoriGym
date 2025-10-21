package Algorithm_Study.daily.PJE.D202510;
import java.util.*;
// 프로그래머스 폰켓몬
public class D20251020 {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        
        int pocketmonLen = nums.length/2; // 뽑아야하는 포켓몬 종류 개수
        int maxLen = set.size();          // 현재 포켓몬 종류
        
        if(pocketmonLen <= maxLen){
            return  pocketmonLen;
        }else{
            return maxLen;
        }
        
    }
}

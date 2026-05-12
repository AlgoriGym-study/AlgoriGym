package Algorithm_Study.daily.PJE.D202605;
import java.util.*;
public class D20260511 {
    public int solution(int[] people, int limit) {
        int answer = 0;
        // 정렬 
        Arrays.sort(people);
        // 가장 가벼운 사람
        int left = 0;
        // 가장 무거운 사람
        int right = people.length-1;
        while(left<=right){
         // 가벼운 사람+무거운 사람이 limit 보다 작을경우에만 보트 탑승
         if(people[left] + people[right] <= limit){
             left++;
         }
        //무거운 사람은 무조건 탑승
            right--;
            answer++;
        }
        return answer;
    }
}

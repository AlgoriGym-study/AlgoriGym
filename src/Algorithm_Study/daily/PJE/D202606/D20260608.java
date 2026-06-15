package Algorithm_Study.daily.PJE.D202606;
import java.util.*;
public class D20260608 {
    public int solution(int[] citations) {
        int answer = 0;
        // 정렬
        Arrays.sort(citations);
        // 반복문에서 h구하고 비교하기
        int len = citations.length;
        for(int i = 0; i < len; i++){
            int h = len-i;
            
            if(citations[i] >= h){
                answer = h;
                 System.out.println(citations[i]+" "+h);
                break;
               
            }
        }
        
        return answer;
    }
}

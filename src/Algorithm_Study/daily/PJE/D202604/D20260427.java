
package Algorithm_Study.daily.PJE.D202604;
import java.util.*;
public class D20260427 {
    public int[] solution(long n) {
        
        StringBuilder sb = new StringBuilder();
        //뒤집기
        sb.append(n).reverse();
        //split으로 나누기
        String[] arr= sb.toString().split("");
        int[] answer = new int[arr.length];
        // int 배열에 옮기기
        for(int i =0; i < arr.length; i++){
            answer[i] = Integer.parseInt(arr[i]);
        }
    
        return answer;
    }
}

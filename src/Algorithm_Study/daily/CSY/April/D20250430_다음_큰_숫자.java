import java.util.*;

public class D20250430_다음_큰_숫자{
    public int solution(int n) {
        int answer = 0;
        // String[] arr = Integer.toBinaryString(n).split("");
        int count = Integer.bitCount(n);
        // for(String s : arr){
        //     if(s.equals("1")) count++;
        // }
        
        boolean isFind = true;
        int comp = n;
        while(isFind){
            comp++;
            int cnt = Integer.bitCount(comp);
//             String[] temp = Integer.toBinaryString(comp).split("");
            
//             for(String t : temp){
//                 if(t.equals("1")) cnt++;
//             }
            if(count == cnt) isFind = false;
            
        }
        return comp;
    }
}

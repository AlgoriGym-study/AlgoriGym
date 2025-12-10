package Algorithm_Study.daily.PJE.D202512;
import java.util.*;

// 프로그래머스 문자열 곱하기 
public class D20251208 {
    public String solution(String my_string, int k) {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < k; i++){
            sb.append(my_string);
        }
        return sb.toString();
    }
}

package Algorithm_Study.daily.PJE.D202602;
import java.util.*;
public class D20260225 {
    public String[] solution(String[] strings, int n) {
        // strings의 n 번째 글자로 strings를 정렬해야함
        Arrays.sort(strings, (s1, s2) -> {
            // n 번째 문자가 다르면
            if(s1.charAt(n) != s2.charAt(n)){
                return Character.compare(s1.charAt(n), s2.charAt(n));
            }
            // n번째 문자가 같으면 문자열 전체를 사전순으로 비교 
            return s1.compareTo(s2);
        });
        return strings;
    }
}

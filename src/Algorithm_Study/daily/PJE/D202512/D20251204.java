package Algorithm_Study.daily.PJE.D202512;
import java.util.*;

// 프로그래머스 문자열섞기
public class D20251204 {

    public String solution(String str1, String str2) {

        int len = str1.length(); 
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            sb.append(str1.charAt(i));
            sb.append(str2.charAt(i));
        }
        return sb.toString();
    }

}

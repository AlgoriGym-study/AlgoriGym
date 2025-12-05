package Algorithm_Study.daily.PJE.D202512;
import java.util.*;

// 프로그래머스 문자 리스트를 문자열로 변환하기
public class D20251205 {
    public String solution(String[] arr) {
        StringBuilder sb = new StringBuilder();
        int len = arr.length;
        for(int i = 0; i < len; i++){
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}

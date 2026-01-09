package Algorithm_Study.daily.PJE.D202601;
import java.util.*;

public class D20260109 {
    public boolean isPalindrome(int x) {
        // 1. 음수는 바로 리턴하기
        if (x < 0) return false;

        String s = String.valueOf(x);
        Stack<Character> stack = new Stack<>();

        // 2. 모든 문자를 스택에 삽입
        for (int i = 0; i < s.length(); i++) {
            stack.push(s.charAt(i));
        }

        // 3. 스택에서 하나씩 꺼내며 원래 문자열과 비교
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

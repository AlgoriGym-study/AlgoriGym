package Algorithm_Study.daily.PJE;
import java.util.Stack;

//프로그래머스 괄호 회전하기 
class D20250423 {
    // "[](){}"	
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
	// 왼쪽으로 돌리기 앞 문자 1개를 뒤로 보내기, 2개 뒤로 보내기.. .
        for (int i = 0; i < len; i++) {
            String rotated = s.substring(i) + s.substring(0, i);
		
            if (isValid(rotated)) {
                answer++;
            }
        }

        return answer;
    }
    // 스택에 넣은 괄호 짝이 맞는지 검사 
    private boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }

        return stack.isEmpty();
    }
}

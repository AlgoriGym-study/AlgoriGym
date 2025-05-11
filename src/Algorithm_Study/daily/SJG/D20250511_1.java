package Algorithm_Study.daily.SJG;

import java.util.Stack;

public class D20250511_1 {
	public int solution(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            
            if (!stack.isEmpty() && stack.peek() == curr) {
                stack.pop();
            } else {
                stack.push(curr);
            }
        }
        
        return stack.isEmpty() ? 1 : 0;
    }
}

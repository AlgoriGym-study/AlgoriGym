package Algorithm_Study.daily.LYR;

import java.util.Stack;

public class D20251211 {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        char[] array = s.toCharArray();
        for(char c : array){
            if(c == '('){
                stack.push('(');
            } else if(c == ')'){
                if(stack.isEmpty())
                    return false;
                else
                    stack.pop();
            }
        }
        if(stack.isEmpty())
            answer = true;
        else
            answer = false;
        return answer;
    }
}

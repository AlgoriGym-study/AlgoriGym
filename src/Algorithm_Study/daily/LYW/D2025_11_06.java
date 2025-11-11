package Algorithm_Study.daily.LYW;
import java.util.*;

public class D2025_11_06 {
    static Map<Character, Character> map;

    static {
        map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');
        map.put('<', '>'); 
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int len = sc.nextInt();
            char[] str = sc.next().toCharArray();
            Stack<Character> stack = new Stack<>();

            boolean isValid = true;
            for (char ch : str) {
                if (map.containsKey(ch)) { // 여는 괄호면 stack에 push
                     stack.push(ch); 
                } else if (map.containsValue(ch)) { // 닫는 괄호면 
                    if (!stack.isEmpty() && map.get(stack.peek()) == ch) { // 스택이 비어있지 않고 맨 위가 닫는괄호랑 짝궁 괄호라면
                        stack.pop();
                    } else {
                        isValid = false;
                        break;
                    }
                }
            }

            int answer = (isValid && stack.isEmpty()) ? 1 : 0;
            System.out.println("#" + tc + " " + answer);
        }
    }
}


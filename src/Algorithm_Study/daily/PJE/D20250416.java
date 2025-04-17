package _0416;

import java.util.Stack;
// 프로그래머스 짝지어 제거하기
public class D20250416 {
	public int solution(String s) {
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			if(!stack.isEmpty() && stack.peek() == c) {
				stack.pop();
			}else {
				stack.push(c);
			}
		}
		int answer = 0;
		if(stack.isEmpty()) answer = 1; 
		return answer;
		
	}
}

package Algorithm_Study.daily.PJE;

import java.util.Arrays;
import java.util.Stack;
// 시간복잡도 O(N)
// 프로그래머스 주식가격
class D20250418 {
	//idx:     0, 1, 2, 3, 4
	//prices: [1, 2, 3, 2, 3]
    public int[] solution(int[] prices) {
    	int n = prices.length;
    	int[] answer = new int [n];
    	Stack<Integer> stack = new Stack<>();
    	stack.push(0);

    	// prices의 idx를 하나씩 스택에 넣어주는데 작은 숫자를 만날경우 
    	// answer에 이전 값과 비교한 인덱스의 차이를 넣어줘야함 
    	for (int i = 1; i < n; i++) {
    			while(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
    				int idx = stack.pop();
    				answer[idx] = i - idx; 
    			}
    			stack.push(i);
    	}
    	//남은 숫자들은 마지막까지 남아있던 숫자들이므로 전체 길이에서 뺀 숫자로 리턴
    	while(!stack.isEmpty()) {
    		int num = stack.pop(); 
    		answer[num] = (n-1)-num;
    	}
    	
    	answer[n-1] = 0;
        return answer;
    }
}
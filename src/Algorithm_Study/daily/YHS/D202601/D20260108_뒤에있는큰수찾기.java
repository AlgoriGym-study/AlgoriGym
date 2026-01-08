package Algorithm_Study.daily.YHS.D202601;

import java.util.*;

public class D20260108_뒤에있는큰수찾기 {
    public int[] solution(int[] numbers) {
        Stack<Integer> stack = new Stack<>();

        int[] answers = new int[numbers.length];

        stack.push(0);

        for (int i = 1; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answers[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answers[stack.pop()] = -1;
        }

        return answers;
    }
}

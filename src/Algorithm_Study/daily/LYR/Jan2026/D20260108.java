package Algorithm_Study.daily.LYR.Jan2026;

import java.util.Stack;

public class D20260108 {
    public boolean solution(int x) {
        String[] numList = String.valueOf(x).split("");
        int sum = 0;
        for(String num : numList){
            sum += Integer.parseInt(num);
        }
        if(x % sum == 0)
            return true;
        else
            return false;
    }

    public int[] solution(long n) {
        String[] list = String.valueOf(n).split("");
        Stack<String> stack = new Stack<>();
        for(String s : list){
            stack.push(s);
        }
        int[] answer = new int[list.length];
        for(int i=0;i<answer.length;i++){
            answer[i] = Integer.parseInt(stack.pop());
        }

        return answer;
    }
}

package Algorithm_Study.daily.LYR.Feb2026;

import java.util.Stack;

public class D20260207 {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length() != 4 && s.length() != 6)
            return false;
        char[] arr = s.toCharArray();
        for(char c : arr){
            if(c - 65 > 0)
                return false;
        }
        return answer;
    }

    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr1[0].length];
        for(int i=0;i<arr1.length;i++){
            for(int j=0;j<arr1[0].length;j++){
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }

    public static void star(int a, int b){
        for(int i=0;i<b;i++){
            for(int j=0;j<a;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public int[] solution(int []arr) {
        Stack<Integer> array = new Stack<>();
        Stack<Integer> result = new Stack<>();
        for(int a : arr){
            array.push(a);
        }

        while(!array.isEmpty()){
            if(result.isEmpty()){
                result.push(array.peek());
                array.pop();
            }
            if(result.peek() == array.peek())
                array.pop();
            else {
                result.push(array.peek());
                array.pop();
            }
        }
        int[] answer = new int[result.size()];
        for(int i=0;i<answer.length;i++){
            answer[i] = result.peek();
            result.pop();
        }

        return answer;
    }
}

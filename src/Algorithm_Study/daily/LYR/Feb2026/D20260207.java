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

    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        if(n > m){
            answer[0] = gcd(n,m);
            answer[1] = lcm(n,m);
        } else {
            answer[0] = gcd(m,n);
            answer[1] = lcm(m,n);
        }
        return answer;
    }

    private int gcd(int n, int m){
        while(m != 0){
            int r = n % m;
            n = m;
            m = r;
        }
        return n;
    }

    private int lcm(int n, int m){
        return n * m / gcd(n,m);
    }
}

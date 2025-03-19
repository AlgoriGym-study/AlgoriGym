package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20250319 {
	static String[] tree;
    static int[] left;
    static int[] right;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 10;
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            tree = new String[N+1];
            left = new int[N+1];
            right = new int[N+1];
            
            for(int i = 0; i < N; i++) {
                String[] input = br.readLine().split(" ");
                int n = Integer.parseInt(input[0]);
                tree[n] = input[1];
                
                if(input.length > 2) {
                    left[n] = Integer.parseInt(input[2]);
                    if(input.length > 3) right[n] = Integer.parseInt(input[3]);
                }
            }
            sb.append("#").append(test_case).append(" ").append(inOrder(1)).append("\n");
		}
        br.close();
        System.out.print(sb);
	}
    
    private static int inOrder(int root) {
        String A = "";
        String op = "";
        String B= "";
        if(left[root] != 0) A = String.valueOf(inOrder(left[root]));
        if(tree[root] != null) op = tree[root];
        if(right[root] != 0) B = String.valueOf(inOrder(right[root]));
		
        if(left[root] != 0 || right[root] != 0) return operator(A, op, B);
        return Integer.parseInt(tree[root]);
    }
    
    private static int operator(String A, String op, String B) {
        int a = Integer.parseInt(A);
        int b = Integer.parseInt(B);
        
        switch(op) {
            case "+":
                return a+b;
            case "-":
                return a-b;
            case "*":
                return a*b;
            case "/":
                return a/b;
        }
        return 0;
    }
}

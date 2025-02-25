package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class D20240225_9012_괄호 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < T; tc++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            boolean check = true;
            for(int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if(c == '(') stack.push(c);
                else  {
                	if(stack.isEmpty()) {
                		sb.append("NO").append("\n");
                		check = false;
                		break;
                	} else stack.pop();
                }
            }
            if(!check) continue;
            
            sb.append(stack.isEmpty() ? "YES" : "NO").append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}

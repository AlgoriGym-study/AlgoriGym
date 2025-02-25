package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class D20240225_9012_괄호 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        // 테스트 케이스 수 만큼 반복 순회
        for(int tc = 0; tc < T; tc++) {
            String input = br.readLine();
            Stack<Character> stack = new Stack<>();
            // 괄호 문자열의 조건을 만족하는지 확인하기 위한 boolean변수 check 선언
            boolean check = true;
            for(int i = 0; i < input.length(); i++) {
            	// 괄호 문자열에서 문자 하나씩 추출
                char c = input.charAt(i);
                // 열린 괄호는 일단 무조건 스택에 추가 
                if(c == '(') stack.push(c);
                else  {
                	// 닫는 괄호일때 스택이 비어 있다면 괄호 문자열의 조건을 만족할 수 없으므로 "NO"를 추가한 후 break
                	if(stack.isEmpty()) {
                		sb.append("NO").append("\n");
                		// 괄호 문자열의 조건을 만족할 수 없기에 check를 false처리
                		check = false;
                		break;
                		// 괄호의 조건을 만족한다면 스택에서 해당 괄호세트(열린괄호)를 소거
                	} else stack.pop();
                }
            }
            // 조건을 만족시킬 수 없고 이미 결과인 "NO"를 StringBuilder객체에 추가해뒀기 때문에 continue를 통해 아래의 코드를 실행시키지 않음. 
            if(!check) continue;
            
            sb.append(stack.isEmpty() ? "YES" : "NO").append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}

package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class D20250302 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for(int tc = 0; tc < T; tc++) {
            String[] NM = br.readLine().split(" ");	// 문서의 개수 N 및 추적할 인덱스 M
            String[] input = br.readLine().split(" ");	// 중요도를 가지고 있는 원소들
            int N = Integer.parseInt(NM[0]); // 문서의 개수 N
            int M = Integer.parseInt(NM[1]); // 추적할 인덱스 M
            
            int max = 1;	// 중요도의 범위가 1~9이므로, 가장 중요도가 낮은 값인 1로 변수 max를 초기
            int prior = 0;	// 추적할 인덱스의 중요도를 할당할 변수 prior 선언
            Stack<Integer> st = new Stack<>();	// 추후 중요도 재탐색을 위한 스택 선언
            Deque<Integer> dq = new LinkedList<>();	// Deque를 사용하여 문제 해결
            
            // 입력받은 중요도들 중 가장 큰 값 추출 및 dq에 추가
            for(int i = 0; i < N; i++) {
                int n = Integer.parseInt(input[i]);
                // max값 재할당
                if(max < n) max = n;
                // 만약 추적할 인덱스의 차례라면 해당 중요도를 변수 prior에 저장하고 해당 원소 값을 0으로 초기화
                // 0으로 초기화 하는 이유는 중요도가 중복이 가능하기 때문에 추적할 원소를 구분하기 위함.
                if(i == M) {
                    prior = n;
                    n = 0;
                }
                // deque에 추가
                dq.addLast(n);
            }
            
            // 추적할 인덱스가 몇번째에 추출되는지 반환해야하므로 변수 cnt 선언
            int cnt = 0;
            while(true) {
            	// dq에서 가장 앞의 원소를 추출
                int n = dq.removeFirst();
                // max값이 추적중인 인덱스의 값과 같고 n이 0이라면 추적중인 원소! -> 반환해야함.
                if(max == prior && n == 0) {
                   ++cnt;
                   break;
                   // max값과 해당 원소의 값이 같으면 최대값에 해당하는 원소이므로 dq에 재추가 X
                } else if(max == n) {
                    ++cnt;
                    // max값을 재할당 해야하므로 중요도를 가장 낮은 값인 1로 초기화
                    max = 1;
                    // dq가 빈 값이 될 때까지 순회
                    while(!dq.isEmpty()) {
                    	// 스택으로 해당 원소들의 순서를 유지하기위해 덱의 가장 뒤의 원소부터 추출
                        int num = dq.removeLast();
                        
                        // max값 재할당
                        if(max < num) max = num;
                        // 추적할 인덱스 값을 0으로 초기화 했기 떄문에 해당 값이 0일 때 중요도 값으로 max값과 비교
                        else if(num == 0 && max < prior) max = prior;
                        // stack에 추가
                        st.push(num);
                    }
                    // 스택이 빌 때까지 다시 dq에 추가 
                    while(!st.isEmpty()) dq.addLast(st.pop());
                } else {
                	// 해당 사항 없을 시 다시 dq에 추가
                    dq.addLast(n);
                }
            }
            sb.append(cnt).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}

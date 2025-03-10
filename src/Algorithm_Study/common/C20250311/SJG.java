package Algorithm_Study.common.C20250311;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SJG {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            String[] input = br.readLine().split(" ");
            int[] arr = new int[N];
            int maxHeight = 0;
            // 나무 높이 입력받음과 동시에 최대높이 확인
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
                if(arr[i] > maxHeight) maxHeight = arr[i];
            }
            // +1, +2를 수행하는 날짜를 위한 변수 선언
            int one = 0;
            int two = 0;
            // 결과값 -> 나무 높이를 최대값과 모두 같게하기 위한
            int totalDay = 0;
            
            for(int tree : arr) {
            	// 최대값과 현재 나무의 높이의 차
                int diff = maxHeight - tree;
                // +1, +2 = +3 -> 3으로 나눌 수 있는 수라면 (높이의 차 / 3) * 2의 값과 같다. 
                // +1을 할 수 있는 날과 +2를 할 수 있는날을 한 세트로 생각.
				if(diff % 3 == 0) {
                    totalDay += (diff / 3) * 2;
                    diff %= 3;
                }
				// 그 외의 날일 때.. 최소값을 찾자
				if(diff >= 2) {
					two = (diff / 2);
                    diff %= 2;
                } else one = diff;
                
                if(one >= two) {
                    totalDay += two;
                    one -= two;
                } else {
                    totalDay += one;
                    two -= one;
                }
                // 여기서 one, two.. 조절을 어떻게 흑
            }
            sb.append("#").append(test_case).append(" ").append(totalDay).append("\n");
		}
        br.close();
        System.out.print(sb);
	}
}

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
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(input[i]);
                if(arr[i] > maxHeight) maxHeight = arr[i];
            }
            
            int totalDay = 0;
            int one = 0;
            int two = 0;

            // 각 나무별로 diff 계산 및 초기 날짜 계산
            for(int tree : arr) {
                int diff = maxHeight - tree;
                if(diff == 0) continue;

                two += diff / 2;
                one += diff % 2;
            }

            // 가능한 한 one과 two를 짝지어서 처리
            int minCnt = Math.min(one, two);
            totalDay += minCnt * 2;
            one -= minCnt;
            two -= minCnt;

            // 남은 one과 two 처리
            if (one > 0) {
                totalDay += (one - 1) * 2 + 1; // one이 남으면 마지막 하나만 하루 소요
            } else if (two > 0) {
                totalDay += (two / 3) * 4;
                int remainder = two % 3;
                if(remainder == 1) totalDay += 2; // 하나 남으면 이틀(+2)
                else if(remainder == 2) totalDay += 3; // 두 개 남으면 삼일(+3)
            }

            sb.append("#").append(test_case).append(" ").append(totalDay).append("\n");
        }
        br.close();
        System.out.print(sb);
    }
}

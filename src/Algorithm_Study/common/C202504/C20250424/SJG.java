package Algorithm_Study.common.C202504.C20250424;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class SJG {
  static int N, K, NLEN;  // N: 숫자, K: 교환횟수, NLEN: N의 자릿수
	static Set<Integer>[] visited;  // visited[i]: i번째 교환횟수에서 방문한 숫자들 -> 중복 방지
  static int maxNum;  // 최대 숫자 -> 출력할 변수
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] input = br.readLine().split(" ");
            N = Integer.parseInt(input[0]);
            K = Integer.parseInt(input[1]);
			      NLEN = String.valueOf(N).length();
            if (NLEN < 2) {
 			        maxNum = N;
			        return;
            } // 자릿수가 1이면 교환할 필요 없음
            visited = new HashSet[K + 1]; // visited[0]은 사용 안함
			      for (int i = 0; i <= K; i++) visited[i] = new HashSet<>();
            maxNum = 0; // maxNum 초기화
            dfs(0, N); // 깊이 우선 탐색 시작
            sb.append("#").append(test_case).append(" ").append(maxNum).append("\n");
		}
        System.out.print(sb);
        br.close();
	}
    
    private static void dfs(int depth, int num) {
        // 교환횟수 달성 시 종료
        if(depth == K) {
            maxNum = maxNum > num ? maxNum : num;
            return;
        }
        
        // 교환횟수 미달성 시
        for(int i = 0; i < NLEN; i++) {
          for (int j = i + 1; j < NLEN; j++) {
              // i와 j의 자리를 교환                  
              int next = swap(num, i, j);
              // 교환 후 숫자가 유효한지 확인
              // 이미 방문한 숫자이거나 교환 후 0을 반환 받으면 맨 앞자리가 0이므로 무시
              if (next == -1 || visited[depth + 1].contains(next))
                continue;
              // 교환 후 숫자가 유효하면 방문 처리
              visited[depth + 1].add(next);
              // 다음 깊이로 이동
              dfs(depth+1, next);
            }
        }
    }
    
    private static int swap(int num, int i, int j) {
      char[] chars = String.valueOf(num).toCharArray();
      // i와 j의 자리를 교환
    	char tmp = chars[i];
	    chars[i] = chars[j];
    	chars[j] = tmp;
        // 맨 앞자리가 0이면 무시 (자릿수 줄어드는 거 방지)
	    if (chars[0] == '0') return -1;
    	return Integer.parseInt(new String(chars));
	}
}

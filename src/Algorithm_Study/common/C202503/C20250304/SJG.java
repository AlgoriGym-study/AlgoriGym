package Algorithm_Study.common.C202503.C20250304;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SJG {
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       	StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        // 델타 배열 (가로, 세로, 우하 대각선, 우상 대각선)
        int[] dr = {0, 1, 1, -1};
        int[] dc = {1, 0, 1, 1};
        
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			int[][] field = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				char[] input = br.readLine().toCharArray();
				for(int j = 0; j < N; j++) {
					char c = input[j];
					if(c == '.') field[i][j] = 0;
					else field[i][j] = 1;
				}
			}
			
			boolean found = false;
			outer:	// 중첩 for문을 한번에 빠져나오기 위한 label 사용
			for (int i = 0; i < N; i++) {
			    for (int j = 0; j < N; j++) {
			        if (field[i][j] == 1) {
			            for (int d = 0; d < 4; d++) {
			                int count = 1;
			                for (int k = 1; k < 5; k++) {
			                    int nr = i + dr[d] * k;
			                    int nc = j + dc[d] * k;

			                   
			                    if (nr < 0 || nr >= N || nc < 0 || nc >= N) break;

			                    if (field[nr][nc] == 1) count++;
			                    else break;
			                }

			                if (count >= 5) {
			                    found = true;
			                    break outer;
			                }
			            }
			        }
			    }
			}

			sb.append("#").append(test_case).append(" ").append(found ? "YES" : "NO").append("\n");
		}
        br.close();
        System.out.print(sb);
	}
}

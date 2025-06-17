package Algorithm_Study.common.C20250611;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SJG0023_2 {
    public static void main(String args[]) throws Exception
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        // 우, 하, 좌, 상
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
            int[][] arr = new int[N][N];
            
            int r = 0;
            int c = 0;
            int dir = 0;
            int k = 1;
            int stepCnt = N;
            int stepDone = 0;
            int turnCnt = 0;
            // N*N까지 채우기
			while(k <= N * N) {
                // 현재 위치에 값 채우기
                arr[r][c] = k++;

                // 방향 회전 여부 및 스텝 카운트 조정
                if(++stepDone == stepCnt) {
                    dir = (dir + 1) % 4;
                    stepDone = 0;
                    // 스텝 카운트 조정
                    if(++turnCnt % 2 == 1) stepCnt--;
                }
                // 다음 위치 계산
                r += dr[dir];
                c += dc[dir];
            }
            
            sb.append("#").append(test_case).append("\n");
            for(int i = 0; i < N; i++) {
            	for(int j = 0; j < N; j++) sb.append(arr[i][j]).append(" ");
            	sb.append("\n");
        	}
		}
        System.out.print(sb);
        br.close();
	}
}

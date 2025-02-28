package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class D20250228 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNM = br.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        int M = Integer.parseInt(inputNM[1]);
        
        char[][] arr = new char[N][M];
        for(int i = 0; i < N; i++) {
            char[] input = br.readLine().toCharArray();
            for(int j = 0; j < M; j++) arr[i][j] = input[j];
        }
        br.close();
        
        int min = 64;
        for(int i = 0; i <= N - 8; i++) {
            for(int j = 0; j <= M - 8; j++) {
                int wCnt = 0;
                int bCnt = 0;
                
                for(int k = 0; k < 8; k++) {
                        for(int l = 0; l < 8; l++) {
                            char c = arr[i+k][j+l];
                            char wStart = ((k+l) % 2 == 0) ? 'W' : 'B';
                            char bStart = ((k+l) % 2 == 0) ? 'B' : 'W';
                            
                            if(c != wStart) wCnt++;
                            if(c != bStart) bCnt++;
                        }
                    }
                
                int minCnt = (wCnt > bCnt) ? bCnt : wCnt;
                if(min > minCnt) {
                    min = minCnt;
                }
            }
        }
        System.out.print(min);
    }
}

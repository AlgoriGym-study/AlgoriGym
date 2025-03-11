import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
public class Solution {
    static int[][] farm;
    static int[] dc = {-1,1};
        public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
             
            farm = new int[N][N];
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    farm[i][j] = str.charAt(j) - '0';
                }
            }
 
            int l = -1;
            int total = 0;
            int col = N/2; //항상 가운데 열부터 시작하므로
            for (int i = 0; i < N; i++) {
                total += farm[i][col];
                if (i <= N/2) {
                    l+=1;
 
                    for (int k = l; k > 0; k--) {
                        for (int d = 0; d < 2; d++) {
                            int nc = col + dc[d] * k;
 
                            if (nc >= 0 && nc < N) total += farm[i][nc];
                        }   
                    }
                }
                else {
                    l-=1;
 
                    for (int k = l; k > 0; k--) {
                        for (int d = 0; d < 2; d++) {
                            int nc = col + dc[d] * k;
 
                            if (nc >= 0 && nc < N) total += farm[i][nc];
                        }   
                    }
                }
            }
 
            System.out.printf("#%d %d\n", tc, total);
        }
    }
}
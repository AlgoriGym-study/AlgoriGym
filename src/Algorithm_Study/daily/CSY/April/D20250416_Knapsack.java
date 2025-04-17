package Algorithm_Study.daily.CSY.April;


    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D20250416_Knapsack {

        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int T = Integer.parseInt(br.readLine().split(" ")[0]);
            StringBuilder sb = new StringBuilder();

            for(int tc = 1; tc <= T; tc++) {
                sb.append("#").append(tc).append(" ");
                StringTokenizer st = new StringTokenizer(br.readLine());
                int N = Integer.parseInt(st.nextToken()); // 물건 수
                int K = Integer.parseInt(st.nextToken()); // 최대 부피
                int[][] dp = new int[N+1][K+1];
                int[][] item = new int[N+1][2]; // 부피, 가치

                for(int i = 1; i <= N; i++) { // 고려하는 물건 수
                    st = new StringTokenizer(br.readLine());
                    item[i][0] = Integer.parseInt(st.nextToken()); // 부피
                    item[i][1] = Integer.parseInt(st.nextToken()); // 가치
                    int v = item[i][0];
                    int c = item[i][1];

                    for(int k = 0; k <= K; k++) { // 각 가치별 최대값
                        // 현재 물건을 고려하지 않은 경우
                        dp[i][k] = dp[i-1][k];

                        // 현재 물건을 고려하는 경우
                        if(k >= v) {
                            dp[i][k] = Math.max(dp[i-1][k], dp[i-1][k-v] + c);
                        }

                    }

                }
                int ans = dp[N][K];

                sb.append(ans).append("\n");
            }//tc
            System.out.println(sb.toString());

        }

    }


package Algorithm_Study.daily.CSY.April;


    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D20250415_장훈이의높은선반 {

        static int N, B, ans;
        static int[] height;

        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int T = Integer.parseInt(br.readLine().split(" ")[0]);
            StringBuilder sb = new StringBuilder();

            for (int tc = 1; tc <= T; tc++) {
                sb.append("#").append(tc).append(" ");
                StringTokenizer st = new StringTokenizer(br.readLine());
                N = Integer.parseInt(st.nextToken()); // 점원의 수
                B = Integer.parseInt(st.nextToken()); // 선반의 높이

                height = new int[N]; // 점원들의 키 배열

                st = new StringTokenizer(br.readLine());
                for (int i = 0; i < N; i++) {
                    height[i] = Integer.parseInt(st.nextToken());
                } // input

                ans = Integer.MAX_VALUE;
                recur(0, 0);

                sb.append(ans-B).append("\n");
            }
            System.out.println(sb.toString());
        }

        static void recur(int idx, int sum) {
            if(sum >= B) {
                ans = Math.min(ans, sum);
                return;
            }

            if(idx == N) return;

            recur(idx+1, sum+height[idx]); // 선택한 경우
            recur(idx+1, sum); // 선택 안 한 경우
        }
    }


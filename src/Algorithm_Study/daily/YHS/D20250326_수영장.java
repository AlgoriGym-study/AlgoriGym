import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250326_수영장 {
    static int[] price;
    static int[] month;
    static int min;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            price = new int[4];
            month = new int[13]; // 직관적으로 보기위해

            /*
             * price[0] = 1일권
             * price[1] = 1달권
             * price[2] = 3달권
             * price[3] = 1년권
             */

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++) {
                month[i] = Integer.parseInt(st.nextToken());
            }

            min = price[3]; // 1년권은 어떤 경우에도 고정이기에 기본값
            dfs(1, 0);
            System.out.printf("#%d %d\n", tc, min);
        }
    }

    // 1월부터 시작하여 해당 월에 1일권, 1달권, 3달권을 이용하는 경우에 대해 재귀 호출
    static void dfs(int idx, int cost) {
        if (idx > 12) {
            min = Math.min(min, cost);
            return;
        }

        if (month[idx] > 0) {
            dfs(idx + 1, cost + (month[idx] * price[0])); // 1일권

            dfs(idx + 1, cost + price[1]); // 1달권

            dfs(idx + 3, cost + price[2]); // 3달권
        } else {
            dfs(idx + 1, cost);
        }
    }

}
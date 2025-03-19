import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250315_규영이와_인영이의_카드게임 {
    static int[] 규영;
    static int[] 인영;
    static boolean[] check;
    static boolean[] visit;
    static int[] ans;
    static int win, lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            규영 = new int[9];
            인영 = new int[9];
            check = new boolean[19];
            visit = new boolean[9];
            ans = new int[9];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 9; i++) {
                int num = Integer.parseInt(st.nextToken());
                규영[i] = num;
                check[num] = true;
            }

            for (int i = 1, j = 0; i < 19; i++) {
                if (!check[i])
                    인영[j++] = i;
            }

            win = 0;
            lose = 0;
            recur(0);
            System.out.printf("#%d %d %d\n", tc, win, lose);
        }
    }

    static void recur(int depth) {
        if (depth == 9) {
            int cnt = 0;
            for (int i = 0; i < 9; i++) {
                int total = 규영[i] + ans[i];
                if (규영[i] < ans[i])
                    cnt += total; // 인영이의 승리
                else
                    cnt -= total; // 규영이의 승리
            }
            if (cnt > 0)
                lose++; // cnt가 0보다 크다면 인영이가 최종 승리한 것(규영이의 패배)
            else
                win++; // 규영이가 최종 승리

            return;
        }

        for (int i = 0; i < 9; i++) {
            if (!visit[i]) {
                visit[i] = true;
                ans[depth] = 인영[i];
                recur(depth + 1);
                visit[i] = false;
            }
        }
    }
}

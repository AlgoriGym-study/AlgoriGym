package Algorithm_Study.common.C202503.C20250318;

import java.io.*;

public class YHS {
    static int[] chess;
    static int N;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());

            chess = new int[N]; // 체스판 생성 (인덱스:row, value: col)
            ans = 0;
            dfs(0);
            System.out.printf("#%d %d\n", tc, ans);
        }
    }

    static void dfs(int depth) {
        if (depth == N) {
            ans++;
            return;
        }

        for (int i = 0; i < N; i++) {
            chess[depth] = i;
            if (isPossible(depth)) {
                dfs(depth + 1);
            }
        }
    }

    static boolean isPossible(int col) {
        for (int i = 0; i < col; i++) {
            if (chess[i] == chess[col])
                return false;
            else if (Math.abs(col - i) == Math.abs(chess[col] - chess[i]))
                return false;
        }
        return true;
    }
}

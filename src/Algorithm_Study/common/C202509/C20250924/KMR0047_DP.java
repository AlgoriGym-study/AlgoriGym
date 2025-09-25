package Algorithm_Study.common.C202509.C20250924;

//백준 1202번 보석 도둑

import java.io.*;
import java.util.*;

public class KMR0047_DP {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수
        int[][] jewerly = new int[N + 1][2];
        int[] bag = new int[K + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            jewerly[i][0] = Integer.parseInt(st.nextToken()); // 보석 무게
            jewerly[i][1] = Integer.parseInt(st.nextToken()); // 보석 가격
        }

        for (int i = 1; i <= K; i++) {
            bag[i] = Integer.parseInt(br.readLine());
        }

        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (jewerly[i][0] <= bag[j]) { // 가방 i가 보석 j를 견딜 수 있을 때
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + jewerly[i][1]);
                    // 가방 j를 선택 안 함과 가방 j를 선택함 중에 가치가 큰 값을 선택
                    continue;
                }
                dp[i][j] = dp[i - 1][j]; // 못 담으면 보석 j를 넣지 않음 가치 그대로 사용
            }
        }

        System.out.println(dp[N][K]);

        br.close();
    }
}

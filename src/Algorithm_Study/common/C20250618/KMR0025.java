package Algorithm_Study.common.C20250618;

import java.util.*;

public class KMR0025 {

    static int answer;
    static int m, n;
    static int[][] q;
    static int[] ans;

    public int solution(int n, int[][] q, int[] ans) {
        m = ans.length;
        this.n = n;
        this.q = q;
        this.ans = ans;
        answer = 0;

        int[] num = new int[n + 1];

        for (int i = 0; i < m; i++) {
            if(ans[i] == 0) {
                for(int x : q[i]) {
                    num[x] = -1;
                }
            }

            if(ans[i] == 5) return 1;
        }

        permutation(0, 1, num);

        return answer;
    }

    static void permutation(int one, int idx, int[] num) {
        if(one > 5) return;

        if(idx == n + 1) {

            if(one != 5) return; // 5개가 선택되지 않으면 반환

            for (int i = 0; i < m; i++) {
                int[] check = q[i];
                int count = 0;

                for (int j = 0; j < 5; j++) {
                    if (num[check[j]] == 1) count++;
                }

                if(count != ans[i]) return; // q에 대한 ans이 맞지 않으면 반환
            }

            answer++; // ans와 맞으면 추가
            return;
        }

        if (num[idx] == -1) {
            permutation(one, idx + 1, num);
            return;
        }

        // 선택
        num[idx] = 1;
        permutation(one + 1, idx + 1, num);

        // 선택하지 않음
        num[idx] = 0;
        permutation(one, idx + 1, num);

    }// 1: 포함, 0: 포함하지 않음, -1: 확실히 제외
}
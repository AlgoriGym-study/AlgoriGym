package Algorithm_Study.common.C202506.C20250618;

import java.util.*;

public class CSY0025 {
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        List<Integer> code = new ArrayList<>();
        dfs(1, code, n, q, ans);
        return answer;
    }

    void dfs(int start, List<Integer> code, int n, int[][] q, int[] ans) {
        if (code.size() == 5) { // 서로 다른 정수 5개가 모이면 유효성 검사(각 조건에 맞는지 체크)
            if (validate(code, q, ans)) answer++;
            return;
        }
        for (int i = start; i <= n; i++) {
            code.add(i);
            dfs(i + 1, code, n, q, ans);
            code.remove(code.size() - 1); // 백트래킹
        }
    }

    boolean validate(List<Integer> code, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) { // 각 q별로 탐색해서 answer의 수와 맞는지 체크
            int count = 0;
            for (int x : q[i]) {
                if (code.contains(x)) count++;
            }
            if (count != ans[i]) return false;
        }
        return true;
    }
}

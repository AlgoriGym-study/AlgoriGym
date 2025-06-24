package Algorithm_Study.common.C20250618;

public class LYW0025_2 {
    int n, m, ansCount = 0;
    int[][] q;
    int[] ans;
    boolean[] picked;

    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.q = q;
        this.ans = ans;
        this.m = q.length;
        this.picked = new boolean[n+1];
        dfs(1, 0);
        return ansCount;
    }

    // cur: 다음 선택할 숫자, cnt: 현재 선택된 수의 개수
    private void dfs(int cur, int cnt) {
        if (cnt == 5) {
            if (matchesAll()) ansCount++;
            return;
        }
        if (cur > n) return;

        // 현재 수(cur)를 포함하고 다음으로
        picked[cur] = true;
        dfs(cur + 1, cnt + 1);
        picked[cur] = false;

        // 현재 수를 포함하지 않고 다음으로
        dfs(cur + 1, cnt);
    }

    private boolean matchesAll() {
        for (int i = 0; i < m; i++) {
            int match = 0;
            for (int num : q[i]) {
                if (picked[num]) match++;
            }
            if (match != ans[i]) return false;
        }
        return true;
    }
}

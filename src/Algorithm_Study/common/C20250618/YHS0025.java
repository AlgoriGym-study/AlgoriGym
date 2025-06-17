package Algorithm_Study.common.C20250618;

public class YHS0025 {
    int count = 0;

    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;

        pickNum(1, 1, n, q, ans, new boolean[n+1]);
        answer = count;

        return answer;
    }

    private void pickNum(int depth, int min, int n, int[][] q, int[] ans, boolean[] pickedNums) {
        if (depth > 5) {
            for (int i = 0; i < q.length; i++) {
                int matchCnt = 0;

                for (int j = 0; j < 5; j++) {
                    if (matchCnt > ans[i]) break;
                    if (pickedNums[q[i][j]] ) matchCnt++;
                }

                if (ans[i] != matchCnt) {
                    return;
                }
            }

            count++;
            return;
        }

        for (int i = min; i <= n; i++) {
          pickedNums[i] = true;
          pickNum(depth + 1, i + 1, n, q, ans, pickedNums);
          pickedNums[i] = false;
        }
    }
}

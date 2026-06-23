package Algorithm_Study.daily.PJE.D202606;
public class D20260621 {
    public int solution(int[][] land) {
        int N = land.length;

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 4; j++) {
                int best = 0;
                for (int k = 0; k < 4; k++) {
                    if (k != j) {
                        best = Math.max(best, land[i-1][k]);
                    }
                }
                land[i][j] += best;
            }
        }

        int answer = 0;
        for (int j = 0; j < 4; j++) {
            answer = Math.max(answer, land[N-1][j]);
        }
        return answer;
    }
}

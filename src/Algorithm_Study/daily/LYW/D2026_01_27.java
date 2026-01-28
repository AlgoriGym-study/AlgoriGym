package Algorithm_Study.daily.LYW;

public class D2026_01_27 {
    public int solution(int[] players, int m, int k) {
        int[] added = new int[24];
        int active = 0;
        int answer = 0;

        for (int i = 0; i < 24; i++) {
            if (i - k >= 0) {
                active -= added[i - k];
            }

            int need = players[i] / m;

            if (active < need) {
                int diff = need - active;
                added[i] = diff;
                active += diff;
                answer += diff;
            }
        }

        return answer;
    }
}


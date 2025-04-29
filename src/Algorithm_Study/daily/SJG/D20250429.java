package Algorithm_Study.daily.SJG;

import java.util.Arrays;

public class D20250429 {
  public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int count = 0;
        for (int i = 0; i < d.length; i++) {
            if (budget >= d[i]) {
                budget -= d[i];
                count++;
            } else {
                break;
            }
        }
        return count;
  }
}

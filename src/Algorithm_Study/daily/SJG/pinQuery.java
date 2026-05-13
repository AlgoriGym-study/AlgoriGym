package Algorithm_Study.daily.SJG;

public class pinQuery {
    public int[] solution(int[] arr, int[][] queries) {
        for (int[] query : queries) {
            int s = query[0];
            int e = query[1];
            int k = query[2];
            
            if (k == 0) {
                if (s == 0) arr[0]++;
                continue;
            }

            int start = (s % k == 0) ? s : s + (k - (s % k));
            
            for (int i = start; i <= e; i += k) {
                arr[i]++;
            }
        }
        return arr;
    }
}

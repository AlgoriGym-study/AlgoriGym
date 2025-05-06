package Algorithm_Study.common.C20250506;

public class YHS {
    static int solution(int[] diffs, int[] times, long limit) {
        int left = 1, right = 1_000_000, ans = -1;
        //이진 탐색
        while (left <= right) {
            int mid = (left + right) / 2;
            long total = 0;

            for (int i = 0; i < diffs.length; i++) {
                if (mid >= diffs[i])
                    total += times[i];
                else {
                    int retry = diffs[i] - mid;
                    //diffs[0] = 무조건 1이라 예외처리 안해도됨
                    total += ((times[i-1] + times[i]) * retry) + times[i];
                    if (total > limit) break;
                }
            }

            if (total <= limit) {
                ans = mid;
                right = mid - 1;
            }
            else
                left = mid + 1;
        }

        return ans;
    }

//    public static void main(String[] args) {
//        int ans = solution(new int[] {1,99999,100000,99995}, new int[] {9999,9001,9999,9001}, 3456789012L);
//
//        System.out.println(ans);
//    }
}

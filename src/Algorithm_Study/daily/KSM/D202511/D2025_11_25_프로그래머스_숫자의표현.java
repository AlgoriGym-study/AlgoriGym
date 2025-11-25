package D202511;

class Solution {
    public int solution(int n) {
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            int sum = 0;
            int t = i;
            while (sum < n) {
                sum += t++;
            }
            if (sum == n) cnt++;
        }
        return cnt;
    }
}

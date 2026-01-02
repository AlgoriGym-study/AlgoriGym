package D202512;

class Solution {
    public int solution(int[] sides) {
        int maxIndex = -1;
        int maxValue = -999;
        for (int i = 0; i < sides.length; i++) {
            if (sides[i] > maxValue) {
                maxIndex = i;
                maxValue = sides[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < sides.length; i++) {
            if (i == maxIndex) continue;
            sum += sides[i];
        }
        if (sum > maxValue) return 1;
        return 2;
    }
}

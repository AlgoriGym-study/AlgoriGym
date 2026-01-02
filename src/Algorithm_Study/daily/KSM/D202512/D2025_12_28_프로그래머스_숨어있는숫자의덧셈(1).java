package D202512;

class Solution {
    public int solution(String my_string) {
        int sum = 0;
        for (int i = 0; i < my_string.length(); i++) {
            int cur = my_string.charAt(i) - '0';
            if (0 <= cur && cur <= 9) sum += cur;
        }
        return sum;
    }
}

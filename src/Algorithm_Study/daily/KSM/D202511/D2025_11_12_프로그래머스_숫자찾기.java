package D202511;

class Solution {
    public int solution(int num, int k) {
        String str = Integer.toString(num);
        int len = str.length();
        for (int i = 1; i <= len; i++) {
            if (str.charAt(i - 1) - '0' == k) return i;
        }
        return -1;
    }
}

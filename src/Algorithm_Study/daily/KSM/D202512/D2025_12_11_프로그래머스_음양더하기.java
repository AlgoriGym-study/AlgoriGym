package D202512;

class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int ret = 0;
        for (int i = 0; i < absolutes.length; i++) {
            ret += absolutes[i] * (signs[i] ? 1 : -1);
        }
        return ret;
    }
}

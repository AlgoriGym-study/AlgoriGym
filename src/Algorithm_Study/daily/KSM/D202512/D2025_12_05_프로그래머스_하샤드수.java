package D202512;

class Solution {
    public boolean solution(int x) {
        int origin = x;
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        if (origin % sum == 0) return true;
        return false;
    }
}

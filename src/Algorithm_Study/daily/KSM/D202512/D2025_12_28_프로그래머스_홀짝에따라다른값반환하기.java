package D202512;

class Solution {
    public int solution(int n) {
        if (n % 2 == 0) return calEven(n);
        return calOdd(n);
    }
    
    public int calEven(int n) {
        int sum = 0;
        int i = 2;
        while (i <= n) {
            sum += i * i;
            i += 2;
        }
        return sum;
    }
    
    public int calOdd(int n) {
        int sum = 0;
        int i = 1;
        while (i <= n) {
            sum += i;
            i += 2;
        }
        return sum;
    }
}

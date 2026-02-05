package Algorithm_Study.daily.LYW;

public class D2026_02_04 {
    public int solution(int n, int k) {
        String s = Integer.toString(n, k);
        String[] parts = s.split("0+");
        int count = 0;
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].length() == 0) continue;
            long val = Long.parseLong(parts[i]);
            if (isPrime(val)) count++;
        }
        return count;
    }
    
    private boolean isPrime(long x) {
        if (x < 2) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        long limit = (long)Math.sqrt(x);
        for (long i = 3; i <= limit; i += 2) {
            if (x % i == 0) return false;
        }
        return true;
    }
}

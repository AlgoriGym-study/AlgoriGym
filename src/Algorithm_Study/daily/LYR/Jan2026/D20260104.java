package Algorithm_Study.daily.LYR.Jan2026;

public class D20260104 {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        if(sqrt == (int) sqrt)
            return (long)Math.pow((int)sqrt + 1,2);
        return -1;
    }
}

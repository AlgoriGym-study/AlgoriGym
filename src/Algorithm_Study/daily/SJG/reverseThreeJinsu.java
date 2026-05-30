package Algorithm_Study.daily.SJG;

public class reverseThreeJinsu {
    public int solution(int n) {
        String str3 = Integer.toString(n, 3);
        
        String reversed = new StringBuilder(str3).reverse().toString();
        
        return Integer.parseInt(reversed, 3);
    }
}

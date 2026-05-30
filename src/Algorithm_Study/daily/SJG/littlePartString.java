package Algorithm_Study.daily.SJG;

public class littlePartString {
    public int solution(String t, String p) {
        int answer = 0;
        int len = p.length();
        
        for (int i = 0; i <= t.length() - len; i++) {
            String target = t.substring(i, i + len);
            
            if (target.compareTo(p) <= 0) {
                answer++;
            }
        }
        
        return answer;
    }
}

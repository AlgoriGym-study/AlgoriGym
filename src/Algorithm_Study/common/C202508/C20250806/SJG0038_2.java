package Algorithm_Study.common.C202508.C20250806;

public class SJG0038_2 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        for (char c : number.toCharArray()) {
            // StringBuilder의 마지막 문자와 비교하여 제거
            while (k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) < c) {
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            sb.append(c);
        }
        
        // 남은 k개 제거
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        
        return sb.toString();
    }
}

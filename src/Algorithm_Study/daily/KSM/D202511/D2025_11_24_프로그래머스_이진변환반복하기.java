package D202511;

class Solution {
    public int zeroCnt, cnt;
    
    public int[] solution(String s) {
        cnt = 0;
        zeroCnt = 0;
        
        while (true) {
            // 1단계: x의 모든 0을 제거
            int cur = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') cur++;
            }

            // 2단계: 새로운 문자열
            int len = s.length() - cur;
            String str = "";
            while (len > 0) {
                str += len % 2;
                len /= 2;
            }
            
            cnt++;
            zeroCnt += cur;
            s = str;
            if (s.equals("1")) break;
        }
        
        return new int[] {cnt, zeroCnt};
    }
}

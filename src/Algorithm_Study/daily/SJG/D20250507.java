package Algorithm_Study.daily.SJG;

public class D20250507 {
	public int[] solution(String s) {
        int count = 0;
        int totalZero = 0;
        
        while (!s.equals("1")) {
            int zeroCount = 0;
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    zeroCount++;
                } else {
                    sb.append(s.charAt(i));
                }
            }
            
            totalZero += zeroCount;
            
            s = Integer.toBinaryString(sb.length());
            count++;
        }
        
        return new int[]{count, totalZero};
    }
}

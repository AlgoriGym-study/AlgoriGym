package Algorithm_Study.common.C202509.C20251001;

public class YHS0048 {
    public String solution(String s) {
        String answer = "";
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        String[] nums = s.split(" ");
        for (String num : nums) {
            int n = Integer.parseInt(num);
            if (n < min) min = n;
            if (n > max) max = n;
        }

        answer += min + " " + max;
        return answer;
    }
}

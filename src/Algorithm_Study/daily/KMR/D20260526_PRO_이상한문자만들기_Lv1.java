package Algorithm_Study.daily.KMR;

public class D20260526_PRO_이상한문자만들기_Lv1 {
    public String solution(String s) {
        int idx = 0;
        String answer = "";
        for (String str : s.split("")) {
            if (str.equals(" ")) {
                answer += str;
                idx = 0;
                continue;
            } else if ((idx + 1) % 2 == 0) {
                answer += str.toLowerCase();
            } else {
                answer += str.toUpperCase();
            }
            idx++;
        }
        return answer;
    }
}

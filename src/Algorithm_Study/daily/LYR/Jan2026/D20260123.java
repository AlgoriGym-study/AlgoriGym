package Algorithm_Study.daily.LYR.Jan2026;

public class D20260123 {
    public String solution(String phone_number) {
        String answer = phone_number.substring(0,phone_number.length()-4).replaceAll(".", "*") + phone_number.substring(phone_number.length()-4);
        return answer;
    }
}

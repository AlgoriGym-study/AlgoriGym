package Algorithm_Study.daily.CSY.April;

public class D20250425_핸드폰번호가리기 {
    public String solution(String phone_number) {

        StringBuilder sb = new StringBuilder();

        String[] phone = phone_number.split("");
        for(int i = 0; i < phone.length - 4; i++){
            phone[i] = "*";
            sb.append(phone[i]);
        }

        for(int i = phone.length - 4; i < phone.length; i++){
            sb.append(phone[i]);
        }

        return sb.toString();
    }
}
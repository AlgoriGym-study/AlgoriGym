package Algorithm_Study.daily.PJE.D202602;
public class D20260223 {
    public String solution(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int i = a.length()-1; // 포인터
        int j = b.length()-1;
        int carry = 0; // 올림

      // 두 숫자 중 하나라도 남았거나 올림수가 있으면 
        while(i >= 0 || j >= 0 || carry > 0){
            int sum = carry;
            if(i >= 0) sum += a.charAt(i--) - '0';
            if(j >= 0) sum += b.charAt(j--) - '0';
            sb.append(sum%10);
            carry = sum/10;
        }
        return sb.reverse().toString();
    }
}

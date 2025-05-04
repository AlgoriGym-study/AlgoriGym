package Algorithm_Study.daily.PJE;
//프로그래머스 핸드폰번호 가리기
class D20250502 {
    public String solution(String phone_number) {
        
        
        char [] ch = phone_number.toCharArray();
        for(int i = 0; i < ch.length-4; i ++){
            ch[i] = '*';
        }
        return String.valueOf(ch);
    }
}

package Algorithm_Study.daily.PJE.D202605;
public class D20260512 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        // 공백 이후 첫문자는 대문자, 나머지는 소문자
        // 단, 첫문자가 알파벳이 아닐 경우는 제외
        
        // 전체 소문자로 변환
        String lowerCase = s.toLowerCase();
        // 첫번째 공백인지 확인하는 변수
        boolean isFirst = true;
        // 공백 이후만 대문자로 변환 
        for(Character c : lowerCase.toCharArray()){
            if(c == ' '){
                isFirst = true;
                answer.append(c);
            }else{
                if(isFirst){
                    answer.append( Character.toUpperCase(c));
                    isFirst = false;
                }else{
                    answer.append(c);
                }
            }
        }
        return answer.toString();
    }
}

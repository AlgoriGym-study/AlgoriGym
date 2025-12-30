package Algorithm_Study.daily.LYR.Dec2025;

public class D20251226 {
    public String solution(String s) {
        String low = s.toLowerCase();
        String answer = "";
        String[] jaden = low.split(" ");
        for(String first : jaden){
            if(first.length() == 0)
                answer += " ";
            else {
                answer += first.substring(0,1).toUpperCase();
                answer += first.substring(1);
                answer += " ";
            }
        }

        if(s.substring(s.length()-1, s.length()).equals(" "))
            return answer;

        return answer.substring(0, answer.length()-1);
    }
}

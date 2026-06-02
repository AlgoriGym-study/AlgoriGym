package Algorithm_Study.daily.LYR.Jun2026;

public class D20260602 {
    public String solution(String my_string) {
        StringBuilder sb = new StringBuilder();
        sb.append(my_string).reverse();
        return sb.toString();
    }

    public String solution(String my_string, String letter) {
        String answer = "";
        char[] mystr = my_string.toCharArray();
        for(char c : mystr){
            if(String.valueOf(c).equals(letter))
                continue;
            answer += String.valueOf(c);

        }
        return answer;
    }
}

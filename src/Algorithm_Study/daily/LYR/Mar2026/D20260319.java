package Algorithm_Study.daily.LYR.Mar2026;

public class D20260319 {
    public String solution(String s, int n) {
        char[] arr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        for(char c : arr){
            if(c == ' ')
                sb.append(Character.toString(c));
            else if(Character.isLowerCase(c)) {
                sb.append(Character.toString('a' + (c - 'a' + n) % 26));
            } else {
                sb.append(Character.toString('A' + (c - 'A' + n) % 26));
            }
        }

        return sb.toString();
    }
}

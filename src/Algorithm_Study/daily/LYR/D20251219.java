package Algorithm_Study.daily.LYR;

public class D20251219 {
    boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;
        char[] ss = s.toCharArray();
        for(char c : ss){
            if(c == 'p' || c == 'P'){
                p++;
            } else if(c == 'y' || c == 'Y'){
                y++;
            }
        }

        if(p == y)
            answer = true;
        else
            answer = false;

        return answer;
    }
}

package Algorithm_Study.daily.LYR.Jan2026;

public class D20260131 {
    public int solution(String s) {
        if(s.contains("one"))
            s = s.replace("one", "1");
        if(s.contains("two"))
            s = s.replace("two", "2");
        if(s.contains("three"))
            s = s.replace("three", "3");
        if(s.contains("four"))
            s = s.replace("four", "4");
        if(s.contains("five"))
            s = s.replace("five", "5");
        if(s.contains("six"))
            s = s.replace("six", "6");
        if(s.contains("seven"))
            s = s.replace("seven", "7");
        if(s.contains("eight"))
            s = s.replace("eight", "8");
        if(s.contains("nine"))
            s = s.replace("nine", "9");
        if(s.contains("zero"))
            s = s.replace("zero", "0");
        int answer = Integer.parseInt(s);
        return answer;
    }
}

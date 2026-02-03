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

    public String solution2(String[] survey, int[] choices) {
        int R =0, T=0;
        int C = 0, F = 0;
        int J = 0, M = 0;
        int A = 0, N = 0;

        for(int i=0;i<survey.length;i++){
            char first = survey[i].charAt(0);
            char second = survey[i].charAt(1);
            //점수
            int score = Math.abs(4-choices[i]);

            //선택지가 비동의면 첫번째 글자 유형에 점수
            if(choices[i] < 4){
                if(first == 'R')
                    R += score;
                else if(first == 'T')
                    T += score;
                else if(first == 'C')
                    C += score;
                else if(first == 'F')
                    F += score;
                else if(first == 'J')
                    J += score;
                else if(first == 'M')
                    M += score;
                else if(first == 'A')
                    A += score;
                else if(first == 'N')
                    N += score;
            }
            else if(choices[i] > 4){
                if(second == 'R')
                    R += score;
                else if(second == 'T')
                    T += score;
                else if(second == 'C')
                    C += score;
                else if(second == 'F')
                    F += score;
                else if(second == 'J')
                    J += score;
                else if(second == 'M')
                    M += score;
                else if(second == 'A')
                    A += score;
                else if(second == 'N')
                    N += score;
            }
        }
        String answer = "";
        if(R >= T)
            answer += "R";
        else
            answer += "T";
        if(C >= F)
            answer += "C";
        else
            answer += "F";
        if(J>=M)
            answer += "J";
        else
            answer += "M";
        if(A>=N)
            answer += "A";
        else
            answer += "N";
        return answer;
    }
}

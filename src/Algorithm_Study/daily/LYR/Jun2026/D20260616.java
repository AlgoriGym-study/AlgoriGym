package Algorithm_Study.daily.LYR.Jun2026;

public class D20260616 {
    public int solution(int[] numbers) {
        int answer = 0;
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(answer < numbers[i] * numbers[j])
                    answer = numbers[i] * numbers[j];
            }
        }
        return answer;
    }

    public String solution(String my_string) {
        String answer = "";

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<my_string.length();i++){
            if(my_string.charAt(i) == 'a' || my_string.charAt(i) == 'e' || my_string.charAt(i) == 'i' || my_string.charAt(i) == 'o' || my_string.charAt(i) == 'u')
                continue;
            else
                sb.append(my_string.charAt(i));
        }
        return sb.toString();
    }

    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        for(int i=0;i<strlist.length;i++){
            answer[i] = strlist[i].length();
        }
        return answer;
    }
}

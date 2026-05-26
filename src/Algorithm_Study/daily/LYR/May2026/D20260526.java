package Algorithm_Study.daily.LYR.May2026;

public class D20260526 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for(int i=0;i<num_list.length;i++){
            answer[i] = num_list[num_list.length-1-i];
        }
        return answer;
    }

    public int[] solution2 (int[] num_list) {
        int[] answer = new int[2];
        int odd = 0;
        int even = 0;
        for(int n : num_list){
            if(n % 2 == 0)
                even++;
            else
                odd++;
        }
        answer[0] = even;
        answer[1] = odd;
        return answer;
    }

    public String solution(String my_string, int n) {
        String answer = "";
        String[] str = my_string.split("");
        for(int i=0;i<str.length;i++){
            answer += str[i].repeat(n);
        }
        return answer;
    }
}

package Algorithm_Study.daily.LYR.May2026;

public class D20260526 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[num_list.length];
        for(int i=0;i<num_list.length;i++){
            answer[i] = num_list[num_list.length-1-i];
        }
        return answer;
    }
}

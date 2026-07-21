package Algorithm_Study.daily.LYR.Jul2026;

public class D20260721 {
    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[num_list.length - n + 1];
        int idx = 0;
        for(int i=n-1;i<num_list.length;i++){
            answer[idx++] = num_list[i];
        }
        return answer;
    }

    public int[] solution(int[] array) {
        int[] answer = new int[2];
        int idx = 0;
        int max = 0;
        for(int i=0;i<array.length;i++){
            if(max < array[i]){
                max = array[i];
                idx = i;
            }
        }
        answer[0] = max;
        answer[1] = idx;
        return answer;
    }

    public int[] solution(int start_num, int end_num) {
        int[] answer = new int[end_num - start_num + 1];
        int idx = 0;
        for(int i=0;i<answer.length;i++){
            answer[idx++] = start_num++;
        }
        return answer;
    }
}

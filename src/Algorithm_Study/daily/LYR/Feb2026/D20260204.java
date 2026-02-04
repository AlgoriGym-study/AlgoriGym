package Algorithm_Study.daily.LYR.Feb2026;

public class D20260204 {
    public int[] solution(int[] arr) {
        if(arr.length == 1){
            return new int[]{-1};
        }
        int[] answer = new int[arr.length-1];
        int idx = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(min > arr[i]){
                min = arr[i];
                idx = i;
            }
        }
        int index = 0;
        for(int i=0;i<arr.length;i++){
            if(i == idx)
                continue;
            answer[index++] = arr[i];
        }
        return answer;
    }
}

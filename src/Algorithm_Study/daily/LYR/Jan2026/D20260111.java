package Algorithm_Study.daily.LYR.Jan2026;

public class D20260111 {
    public int solution(int[] numbers) {
        boolean[] isExist = new boolean[10];
        for(int i=0;i<10;i++){
            for(int num : numbers){
                if(i==num)
                    isExist[i] = true;
            }
        }

        int answer = 0;
        for(int i=0;i<10;i++){
            if(!isExist[i])
                answer += i;
        }
        return answer;
    }
}

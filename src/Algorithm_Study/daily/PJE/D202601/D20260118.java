package Algorithm_Study.daily.PJE.D202601;

public class D20260118 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        // 첫항이 a 등차가 d 불린배열 included 
        for(int i = 0; i < included.length; i++){
            if(included[i]){
                    answer+=a+d*i;
            }
        }
        return answer;
    }
}

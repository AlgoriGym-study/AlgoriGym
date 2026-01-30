package Algorithm_Study.daily.PJE.D202601;
public class D20260130 {
    public String[] solution(String[] names) {
        int len = names.length/5;
        if (names.length%5 != 0 ) len = names.length/5+1;
        
        String[] answer = new String[len];
        for(int i = 0,idx = 0; i < names.length; i++){
            if(i%5==0){
                answer[idx++] = names[i]; 
            }
        }
        return answer;
    }
}

package Algorithm_Study.daily.PJE.D202602;
public class D20260226 {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length*k];
        int idx = 0;
        for(String pic : picture){
            StringBuilder sb = new StringBuilder();

            // pic의 요소 하나를 k 번 반복한 후 sb에 추가
            for(int i = 0; i < pic.length(); i++){
                char ch = pic.charAt(i);
                sb.append((ch+"").repeat(k));
            }
            for(int j = 0; j < k; j++){
                answer[idx++] = sb.toString();
            }
                
        }
        return answer;
    }
}

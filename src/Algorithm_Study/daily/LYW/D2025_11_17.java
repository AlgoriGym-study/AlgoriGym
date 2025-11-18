package Algorithm_Study.daily.LYW;

public class D2025_11_17 {
    public String solution(int[] food) {

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < food.length; i++){
            if(food[i] / 2 == 0) continue; // 음식의 개수가 1개일 때
            int cnt = food[i] / 2;
            while(cnt > 0){
                sb.append(i);
                cnt--;
            }
        }

        StringBuilder revStr = new StringBuilder(sb.toString()).reverse();
        sb.append(0);
        sb.append(revStr.toString());


        return sb.toString();
    }
}

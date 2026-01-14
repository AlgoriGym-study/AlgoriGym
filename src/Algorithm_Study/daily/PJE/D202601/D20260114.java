package Algorithm_Study.daily.PJE.D202601;
import java.util.*;

public class D20260114 {
    public String solution(String[] survey, int[] choices) {
        // survey : ["AN", "CF", "MJ", "RT", "NA"] choices : [5, 3, 2, 7, 5]
        // 1. 해시맵 초기화 
        Map<Character, Integer> scoreMap = new HashMap<>();
        char[] charArr = "RTCFJMAN".toCharArray();
        for(char c : charArr){
            scoreMap.put(c,0);
        }
        // 2. 점수 계산

        // 1,2,3까지는 앞에꺼 3,2,1고 5,6,7은 뒤에꺼 1,2,3
        for(int i = 0; i < survey.length; i++){
            char first = survey[i].charAt(0);  
            char second = survey[i].charAt(1); 
            int choice = choices[i];

            switch (choice) {
                case 1: scoreMap.put(first, scoreMap.get(first) + 3); break;
                case 2: scoreMap.put(first, scoreMap.get(first) + 2); break;
                case 3: scoreMap.put(first, scoreMap.get(first) + 1); break;
                case 5: scoreMap.put(second, scoreMap.get(second) + 1); break;
                case 6: scoreMap.put(second, scoreMap.get(second) + 2); break;
                case 7: scoreMap.put(second, scoreMap.get(second) + 3); break;
                default: break;
            }
        }
        // 3. 점수 확인 
        StringBuilder answer = new StringBuilder();
        answer.append(scoreMap.get('R') >= scoreMap.get('T') ? 'R' : 'T');
        answer.append(scoreMap.get('C') >= scoreMap.get('F') ? 'C' : 'F');
        answer.append(scoreMap.get('J') >= scoreMap.get('M') ? 'J' : 'M');
        answer.append(scoreMap.get('A') >= scoreMap.get('N') ? 'A' : 'N');
        return answer.toString();
    }
}

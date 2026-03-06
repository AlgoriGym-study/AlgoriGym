package Algorithm_Study.daily.PJE.D202603;
import java.util.*;
public class D20260306 {
    public int[] solution(String s) {
        int[] answer = new int [s.length()];
        // map 으로 알파벳과 위치를 저장
        // map에 글자가 없으면 -1, 있으면 현재 인덱스에서 map 인덱스를 빼서 정답배열에 넣고 map에 업데이트
        Map <Character, Integer> idxMap = new HashMap<>();
        char [] charArr = s.toCharArray();
        for(int i = 0; i < s.length(); i++ ){
            char ch = charArr[i];
            answer[i] = i-idxMap.getOrDefault(ch,i+1);
            idxMap.put(charArr[i],i);
        }
      
        return answer;
    }
}

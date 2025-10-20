package Algorithm_Study.daily.PJE.D202510;
import java.util.*;

//프로그래머스 완주하지 못한 선수
public class D20251017 {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();

        // 참가자 명단 저장
        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        // 완주자 명단 빼기
        for (String c : completion) {
            map.put(c, map.get(c) - 1);
        }

        // 값이 0이 아닌 선수가 미완주자
        for (String key : map.keySet()) {
            if (map.get(key) != 0) {
                return key;
            }
        }

        return null; 
    }
}

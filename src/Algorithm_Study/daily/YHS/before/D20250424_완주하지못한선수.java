package Algorithm_Study.daily.YHS.before;

import java.util.HashMap;
import java.util.Map;

public class D20250424_완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0)+1);
        }

        String ans = "";
        for (String name : completion) {
            map.put(name, map.get(name)-1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) != 0) {
                ans = name;
                break;
            }
        }

        return ans;
    }
}

package Algorithm_Study.daily.YHS.before;

import java.util.HashMap;
import java.util.Map;

public class D20250428_의상 {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        int ans = 1;

        for (int i = 0; i < clothes.length; i++) {
            String key = clothes[i][1];
            map.put(key, map.getOrDefault(key, 0) + 1);
        }

        for (String key : map.keySet()) {
            ans *= (map.get(key) + 1);
        }

        return ans - 1;
    }
}

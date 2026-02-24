package Algorithm_Study.daily.YHS.D202602;

import java.util.HashMap;
import java.util.Map;

public class D20260224_달리기경주 {
    public String[] solution(String[] players, String[] callings) {

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++) {
            map.put(players[i], i);
        }

        for (String name : callings) {
            int idx = map.get(name);
            String prev = players[idx-1];

            players[idx-1] = name;
            players[idx] = prev;

            map.put(name, map.get(name)-1);
            map.put(prev, map.get(prev)+1);
        }

        return players;
    }
}

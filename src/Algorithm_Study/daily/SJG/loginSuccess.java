package Algorithm_Study.daily.SJG;

import java.util.HashMap;
import java.util.Map;

public class loginSuccess {
    public String solution(String[] id_pw, String[][] db) {
        String targetId = id_pw[0];
        String targetPw = id_pw[1];
        
        Map<String, String> dbMap = new HashMap<>();
        for (String[] account : db) {
            dbMap.put(account[0], account[1]);
        }
        
        if (dbMap.containsKey(targetId)) {
            if (dbMap.get(targetId).equals(targetPw)) {
                return "login";
            } else {
                return "wrong pw";
            }
        }
        
        return "fail";
    }
}

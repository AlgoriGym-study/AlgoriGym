package Algorithm_Study.daily.SJG;

import java.util.*;
import java.io.*;

public class D20250502 {
  public int[] solution(String s) {
        int len = s.length();
        int[] answer = new int[len];

        Map<Character, Integer> lastIndex = new HashMap<>();
        
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            // 이전에 등장한 적이 있으면 거리 계산, 아니면 -1
            if (lastIndex.containsKey(c)) {
                answer[i] = i - lastIndex.get(c);
            } else {
                answer[i] = -1;
            }
            // 현재 위치로 갱신
            lastIndex.put(c, i);
        }
        return answer;
    }
}

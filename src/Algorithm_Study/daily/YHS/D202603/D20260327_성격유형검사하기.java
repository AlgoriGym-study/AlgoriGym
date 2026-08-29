package Algorithm_Study.daily.YHS.D202603;

import java.util.HashMap;
import java.util.Map;

public class D20260327_성격유형검사하기 {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();

        Character[] types = {'R','T','C','F','J','M','A','N'};
        Map<Character, Integer> map = new HashMap<>();

        for (char i : types) {
            map.put(i, 0);
        }

        for (int i = 0; i < survey.length; i++) {
            char left = survey[i].charAt(0);
            char right = survey[i].charAt(1);
            int choice = choices[i];

            if (choice < 4) map.put(left, map.get(left) + (4-choice));
            else map.put(right, map.get(right) + (choice-4));
        }

        for (int i = 0; i < types.length; i+=2) {
            if (map.get(types[i]) >= map.get(types[i+1])) answer.append(types[i]);
            else answer.append(types[i+1]);
        }


        return answer.toString();
    }
}

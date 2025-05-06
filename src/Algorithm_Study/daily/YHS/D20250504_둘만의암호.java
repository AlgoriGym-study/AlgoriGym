package Algorithm_Study.daily.YHS;

import java.util.ArrayList;
import java.util.List;

public class D20250504_둘만의암호 {
    public String solution(String s, String skip, int index) {
        List<Character> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            list.add((char) ('a' + i));
        }

        for (Character alphabet : skip.toCharArray()) {
            list.remove(alphabet);
        }

        StringBuilder sb = new StringBuilder();
        for (Character ch : s.toCharArray()) {
            int idx = list.indexOf(ch);
            idx = (idx + index) % list.size();
            sb.append(list.get(idx));
        }

        return sb.toString();
    }
}

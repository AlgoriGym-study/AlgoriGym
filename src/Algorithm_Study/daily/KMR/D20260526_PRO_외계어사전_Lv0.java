package Algorithm_Study.daily.KMR;

import java.util.HashSet;
import java.util.Set;

public class D20260526_PRO_외계어사전_Lv0 {
    public int solution(String[] spell, String[] dic) {
        Set<Character> spellSet = new HashSet<>();
        for (String s : spell) {
            spellSet.add(s.charAt(0));
        }

        for (String word : dic) {
            Set<Character> wordSet = new HashSet<>();
            for (char c : word.toCharArray()) {
                wordSet.add(c);
            }
            if (wordSet.equals(spellSet)) {
                return 1;
            }
        }

        return 2;
    }
}

package Algorithm_Study.daily.KMR;

import java.util.*;

public class D20260607_PRO_단어변환 {
    public int solution(String begin, String target, String[] words) {
        if (!Arrays.asList(words).contains(target)) return 0;

        Queue<String[]> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new String[]{begin, "0"});
        visited.add(begin);

        while(!queue.isEmpty()) {
            String[] cur = queue.poll();
            String word = cur[0];
            int step = Integer.parseInt(cur[1]);

            for (String next : words) {
                if (visited.contains(next) || !isConvertible(word, next)) continue;

                if (next.equals(target)) return step + 1;

                visited.add(next);
                queue.add(new String[]{next, String.valueOf(step + 1)});
            }
        }

        return 0;
    }

    private boolean isConvertible(String a, String b) {
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) diff++;
        }
        return diff == 1;
    }
}

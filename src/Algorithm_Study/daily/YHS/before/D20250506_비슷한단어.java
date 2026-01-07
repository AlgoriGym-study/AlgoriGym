package Algorithm_Study.daily.YHS.before;

import java.io.*;
import java.util.*;

class D20250506_비슷한단어 {
    static int N;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        HashMap<String, String> map = new HashMap<>();
        String S = "";
        String T = "";
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                String s = word.substring(0, j + 1);
                if (map.containsKey(s)) {
                    if (s.length() > cnt) {
                        S = map.get(s);
                        T = word;
                        cnt = s.length();
                    }
                } else
                    map.put(s, word);
            }
        }

        System.out.println(S);
        System.out.println(T);
    }
}

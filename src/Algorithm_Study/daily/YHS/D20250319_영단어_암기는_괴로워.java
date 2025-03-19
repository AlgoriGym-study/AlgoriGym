package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class D20250319_영단어_암기는_괴로워 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Map<String, Integer> words = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() >= M) {
                words.put(input, words.getOrDefault(input, 0) + 1);
            }
        }

        List<String> keySet = new ArrayList<>(words.keySet());

        Collections.sort(keySet, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // 빈도순 정렬 (o1의 value - o2의 value 가 0이 아닌 경우)
                if (Integer.compare(words.get(o1), words.get(o2)) != 0) {
                    return Integer.compare(words.get(o2), words.get(o1));
                }
                // 빈도 수가 같으면 길이가 긴 단어가 먼저 오도록 정렬
                if (o1.length() != o2.length()) {
                    return o2.length() - o1.length();
                }
                // 전부 같다면 알파벳 순으로 정렬
                return o1.compareTo(o2);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String word : keySet) {
            sb.append(word + "\n");
        }

        System.out.println(sb);
    }
}

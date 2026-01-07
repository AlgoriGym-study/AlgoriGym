package Algorithm_Study.daily.YHS.before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class D20250312_나는야포켓몬마스터 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        HashMap<String, Integer> dict = new HashMap<>();
        HashMap<Integer, String> dict2 = new HashMap<>();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            dict.put(name, i);
            dict2.put(i, name);
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (isNumeric(input))
                sb.append(dict2.get(Integer.parseInt(input)));
            else
                sb.append(dict.get(input));
            sb.append("\n");
        }

        System.out.println(sb.toString());

    }

    static boolean isNumeric(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}

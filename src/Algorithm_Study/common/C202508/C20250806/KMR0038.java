package Algorithm_Study.common.C202508.C20250806;

public class KMR0038 {

    public String solution(String number, int k) {
        char[] num = number.toCharArray();

        int len = number.length();
        int idx = 0;

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len - k; i++) {
            char c = '0';
            for (int j = idx; j <= k + i; j++) {
                if (num[j] - c > 0) {
                    c = num[j];
                    idx = j;
                }
            }

            sb.append(c);
            idx++;
        }

        return sb.toString();
    }

}

package Algorithm_Study.common.C202508.C20250806;

public class KMR0038_2 {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (int i = 0; i < number.length() - k; i++) { //뽑는 개수
            char c = '0';
            for (int j = idx; j <= k + i; j++) { // 남은 문자의 개수 >= 뽑아야 하는 문자의 개수
                if (number.charAt(j) > c) {
                    idx = j + 1;
                    c = number.charAt(j);
                }
            }
            sb.append(c);
        }

        return sb.toString();
    }
}

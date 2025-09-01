package Algorithm_Study.common.C202508.C20250806;

public class YHS0038 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int len = number.length() - k;
        int start = 0;

        while (start < number.length() && answer.length() != len) {
            int leftNum = k + answer.length() + 1;
            int max = 0;
            for (int j = start; j < leftNum; j++) {
                if (max < number.charAt(j) - '0') {
                    max = number.charAt(j) - '0';
                    start = j + 1;
                }
            }
            answer.append(Integer.toString(max));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        YHS0038 yhs0038 = new YHS0038();
        System.out.println(yhs0038.solution("1924", 2)); // "94"
        System.out.println(yhs0038.solution("1231234", 3)); // "3234"
        System.out.println(yhs0038.solution("4177252841", 4)); // "775841"
    }
}

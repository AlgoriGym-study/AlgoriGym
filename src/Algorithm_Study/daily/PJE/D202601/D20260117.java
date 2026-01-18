package Algorithm_Study.daily.PJE.D202601;
public class D20260117 {
    public String solution(String code) {
        StringBuilder answer = new StringBuilder();
        int mode = 0;

        for (int i = 0; i < code.length(); i++) {
            char current = code.charAt(i);

            // 1. 문자가 '1'인 경우 mode를 전환
            if (current == '1') {
                mode = (mode == 0) ? 1 : 0;
                continue;
            }

            // 2. mode에 따라 인덱스 조건에 맞는 문자 추가
            if (mode == 0) {
                // mode가 0일 때는 짝수 인덱스만 추가
                if (i % 2 == 0) {
                    answer.append(current);
                }
            } else {
                // mode가 1일 때는 홀수 인덱스만 추가
                if (i % 2 != 0) {
                    answer.append(current);
                }
            }
        }

        // 3. 결과가 빈 문자열이면 "EMPTY"를 반환, 아니면 문자열로 변환
        return answer.length() == 0 ? "EMPTY" : answer.toString();
    }
}

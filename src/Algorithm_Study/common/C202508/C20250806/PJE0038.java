package Algorithm_Study.common.C202508.C20250806;
// 프로그래머스 큰 수 만들기 
public class PJE0038 {
    public String solution(String number, int k) {
        StringBuilder result = new StringBuilder(); //스택처럼 사용

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            // k > 0이고, 마지막 숫자가 현재 숫자보다 작으면 제거
            while (k > 0 && result.length() > 0 && result.charAt(result.length() - 1) < current){
                result.deleteCharAt(result.length() - 1);
                k--;
            }

            // 현재 숫자 추가
            result.append(current);
        }

        // 제거가 안되어서 k가 남아있으면 뒤에서 자르기 (내림차순 숫자였다는 의미)
        return result.substring(0, result.length() - k);
    }
}

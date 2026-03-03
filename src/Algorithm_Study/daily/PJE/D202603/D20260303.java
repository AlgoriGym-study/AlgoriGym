package Algorithm_Study.daily.PJE.D202603;
public class D20260303 {
    public int solution(String s) {

        int answer = s.length();

        // 1. 몇 글자 단위(step)로 자를지 정하기
        for (int step = 1; step <= s.length() / 2; step++) {
            StringBuilder compressed = new StringBuilder();
            String pattern = s.substring(0, step); // 첫 번째 덩어리를 기준으로 잡기
            int count = 1; // 반복 횟수

            // 2. step만큼 건너뛰면서 다음 덩어리들과 비교
            for (int j = step; j <= s.length(); j += step) {
                // 비교할 다음 덩어리 추출 (마지막 남는 부분 처리 주의)
                String next = "";
                if (j + step <= s.length()) {
                    next = s.substring(j, j + step);
                } else {
                    next = s.substring(j); // 남은 짜투리
                }

                if (pattern.equals(next)) {
                    count++; // 같으면 카운트 증가
                } else {
                    // 다르면? 지금까지의 결과를 compressed에 추가
                    if (count >= 2) compressed.append(count);
                    compressed.append(pattern);
                    
                    // 기준(pattern)을 현재 덩어리로 교체하고 카운트 리셋
                    pattern = next;
                    count = 1;
                }
            }
            
            // 3. 마지막에 남은 pattern 처리
            compressed.append(pattern);

            // 4. 이번 step에서 만들어진 문자열 중 가장 짧은 것 저장
            answer = Math.min(answer, compressed.length());
        }

        return answer;
    }
}

package Algorithm_Study.daily.PJE.D202512;
public class D20251224 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow; // 전체 격자의 개수

        // 세로(h)는 최소 3부터 시작
        for (int h = 3; h <= total; h++) {
            if (total % h == 0) { // 전체 개수가 h로 나누어 떨어질 때 (약수일 때)
                int w = total / h; // 가로 길이 계산

                // 노란색 격자 수 공식: (가로 - 2) * (세로 - 2) == yellow                
              if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                    break; // 답을 찾았으니 루프 종료
                }
            }
        }
        return answer;
    }
}

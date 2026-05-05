package Algorithm_Study.daily.PJE.D202605;
public class D20260504 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int rollerEnd = 0; // 롤러로 칠할 수 있는 마지막 구역

        for (int sec : section) {
            // 현재 구역이 이전에 칠한 범위에 포함되지 않는 경우
            if (sec > rollerEnd) {
                answer++;
                rollerEnd = sec + m - 1; // 롤러가 칠할 수 있는 끝 지점으로 범위 갱신
            }
        }

        return answer;
    }
}

package Algorithm_Study.daily.PJE.D202510;
import java.util.*;
// 프로그래머스 같은숫자는 싫어
public class D20251027 {
    public int[] solution(int[] arr) {
        if (arr == null || arr.length == 0) return new int[0];

        Deque<Integer> dq = new ArrayDeque<>();
        Integer prev = null;

        for (int x : arr) {
            if (prev == null || prev != x) {
                dq.addLast(x);  // 원순서대로 쌓음
                prev = x;
            }
        }

        int[] answer = new int[dq.size()];
        int i = 0;
        for (int v : dq) answer[i++] = v; // 바로 순서대로 복사
        return answer;
    }
}

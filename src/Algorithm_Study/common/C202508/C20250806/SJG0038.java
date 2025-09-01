package Algorithm_Study.common.C202508.C20250806;

import java.util.ArrayDeque;
import java.util.Deque;

public class SJG0038 {
    public String solution(String number, int k) {
        Deque<Character> dq = new ArrayDeque<>();
    for (char c : number.toCharArray()) {
        while (k > 0 && !dq.isEmpty() && dq.peekLast() < c) {
            dq.removeLast();
            k--;
        }
        dq.addLast(c);
    }
    for (int i = 0; i < k; i++) {
        dq.removeLast();
    }

    StringBuilder sb = new StringBuilder();
    while (!dq.isEmpty()) {
        sb.append(dq.removeFirst());
    }
    return sb.toString();
    }
}

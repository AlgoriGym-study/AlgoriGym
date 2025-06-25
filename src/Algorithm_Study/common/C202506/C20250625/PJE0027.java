package Algorithm_Study.common.C202506.C20250625;

import java.util.*;
// 백준 숨바꼭질3
public class PJE0027 {
    static final int MAX = 100_001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // 수빈이의 위치
        int K = sc.nextInt(); // 동생의 위치

        int[] time = new int[MAX];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(N);
        Arrays.fill(time, -1);
        time[N] = 0;

        while (!deque.isEmpty()) {
            int now = deque.poll();

            if (now == K) {
                System.out.println(time[now]);
                return;
            }

            if (now * 2 < MAX && time[now * 2] == -1) {
                time[now * 2] = time[now];
                deque.addFirst(now * 2); // 0초이므로 앞에 넣음
            }
            if (now - 1 >= 0 && time[now - 1] == -1) {
                time[now - 1] = time[now] + 1;
                deque.addLast(now - 1);
            }
            if (now + 1 < MAX && time[now + 1] == -1) {
                time[now + 1] = time[now] + 1;
                deque.addLast(now + 1);
            }
        }
    }
}

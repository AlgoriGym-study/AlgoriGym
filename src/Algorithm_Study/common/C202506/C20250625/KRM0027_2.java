package Algorithm_Study.common.C202506.C20250625;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class KRM0027_2 {

    static int LIMIT = 100001;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        int[] time = new int[LIMIT];
        Arrays.fill(time, Integer.MAX_VALUE);
        time[N] = 0;

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);

        while (!dq.isEmpty()) {
            int cur = dq.poll();

            if(cur == K) break;

            if (cur * 2 < LIMIT && time[cur * 2] < 0 ) {
                time[cur * 2] = time[cur];
                dq.addFirst(cur * 2);
            } // 순간이동
            if (cur - 1 >= 0 && time[cur - 1] < 0) {
                dq.addLast(cur - 1);
                time[cur - 1] = time[cur] + 1;
            } // 1칸 뒤로
            if (cur + 1 < LIMIT && time[cur] < 0) {
                time[cur + 1] = time[cur] + 1;
                dq.addLast(cur + 1);
            }
        }// while

        System.out.println(time[K]);

        sc.close();
    }// main
}

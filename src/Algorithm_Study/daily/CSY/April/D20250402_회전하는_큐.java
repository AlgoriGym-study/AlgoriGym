package Algorithm_Study.daily.CSY.April;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
public class D20250402_회전하는_큐 {

        static int count, target;
        static Deque<Integer> dq;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            dq = new LinkedList<>();
            for (int i = 1; i <= N; i++) {
                dq.add(i);
            }

            count = 0;

            for (int i = 0; i < M; i++) {
                target = Integer.parseInt(st.nextToken());
                func(target);
            }

            System.out.println(count);
        }

        // 이 함수에서 실행하기!!
        static void func(int t) {
            int find = 0;

            if (t == dq.peek()) {
                dq.pollFirst();
            } else {
                for (int i : dq) {
                    if (t == i)
                        break;
                    find++;
                }

                if (find > dq.size() / 2) {
                    while (t != dq.peekFirst()) {
                        dq.addFirst(dq.pollLast());
                        count++;
                    }
                    dq.pollFirst();
                }else {
                    while (t != dq.peekFirst()) {
                        dq.addLast(dq.pollFirst());
                        count++;
                    }
                    dq.pollFirst();
                }
            }
        }


}

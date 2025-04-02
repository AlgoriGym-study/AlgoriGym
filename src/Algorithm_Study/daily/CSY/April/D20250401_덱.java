package Algorithm_Study.daily.CSY.April;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class D20250401_덱 {

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st;
            Deque<Integer> dq = new LinkedList<>();
            int N = Integer.parseInt(br.readLine());

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());

                String c = st.nextToken();

                switch(c) {
                    case "push_front":
                        int x = Integer.parseInt(st.nextToken());
                        dq.addFirst(x);
                        break;
                    case "push_back":
                        int y = Integer.parseInt(st.nextToken());
                        dq.addLast(y);
                        break;
                    case "pop_front":
                        if(dq.isEmpty()) {
                            System.out.println(-1);
                        }else {
                            System.out.println(dq.pollFirst());
                        }
                        break;
                    case "pop_back":
                        if(dq.isEmpty()) {
                            System.out.println(-1);
                        }else {
                            System.out.println(dq.pollLast());
                        }
                        break;
                    case "size":
                        System.out.println(dq.size());
                        break;
                    case "empty":
                        if(dq.isEmpty()) {
                            System.out.println(1);
                        }else {
                            System.out.println(0);
                        }
                        break;
                    case "front":
                        if(dq.isEmpty()) {
                            System.out.println(-1);
                        }else {
                            System.out.println(dq.peekFirst());
                        }
                        break;
                    case "back":
                        if(dq.isEmpty()) {
                            System.out.println(-1);
                        }else {
                            System.out.println(dq.peekLast());
                        }
                        break;
                }// switch

            }
        }

}

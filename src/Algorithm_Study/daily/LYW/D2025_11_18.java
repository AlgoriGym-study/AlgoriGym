package Algorithm_Study.daily.LYW;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class D2025_11_18 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
         
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            Deque<Integer> dq = new ArrayDeque<>();
            dq.add(Integer.parseInt(st.nextToken()));
            for(int i = 1; i < 10; i++) {
                int n = Integer.parseInt(st.nextToken());
                if(dq.peekLast() >= n) dq.addFirst(n);
                else dq.addLast(n);
            }
            sb.append("#").append(test_case).append(" ").append(dq.peekLast()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}

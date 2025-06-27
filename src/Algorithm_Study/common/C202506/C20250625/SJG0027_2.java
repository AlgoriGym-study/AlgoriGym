package Algorithm_Study.common.C202506.C20250625;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class SJG0027_2 {
    public static void main(String[] args) throws Exception {
        final int MAX  = 100_001;
        final int MAX_VALUE = Integer.MAX_VALUE;
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        int[] time = new int[MAX];
        
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(N);
        
        for(int i = 0; i < MAX; i++) time[i] = MAX_VALUE;
        time[N] = 0;
        
        while(!dq.isEmpty()) {
            int now = dq.pollFirst();
            int t = time[now];
            
            if(now == M) {
                System.out.print(time[M]);
                br.close();
                return;
            }
            
            if(now * 2 < MAX && time[now * 2] > t) {
                time[now * 2] = time[now];
                dq.addFirst(now * 2);
            }
            
            if(now + 1 < MAX && time[now + 1] > t + 1) {
                time[now + 1] = time[now] + 1;
                dq.addLast(now + 1);
            }
            
            if(now - 1 >= 0 && time[now - 1] > t + 1) {
                time[now - 1] = time[now] + 1;
                dq.addLast(now - 1);
            }
        }
    }
}

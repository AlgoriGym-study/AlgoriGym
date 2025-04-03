package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250402 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> {
           return b - a; 
        });
        
        for(int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n == 0) {
                if(pq.size() == 0) sb.append(0);
                else sb.append(pq.poll());
                sb.append("\n");
            }
            else pq.offer(n);
        }
        br.close();
        System.out.print(sb);
    }
}

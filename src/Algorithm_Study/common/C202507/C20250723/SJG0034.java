package Algorithm_Study.common.C202507.C20250723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;

public class SJG0034 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        
        Queue<Integer> maxHeap = new PriorityQueue<>((n1, n2) -> {
            return n2 - n1;
        });
        Queue<Integer> minHeap = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if(maxHeap.isEmpty() || input <= maxHeap.peek()) maxHeap.offer(input);
            else minHeap.offer(input);
            
            if(maxHeap.size() > minHeap.size() + 1) minHeap.offer(maxHeap.poll());
            else if(minHeap.size() > maxHeap.size()) maxHeap.offer(minHeap.poll());
            
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}

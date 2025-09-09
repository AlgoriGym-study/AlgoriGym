package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class D20250909_2 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
 
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());
             
            Queue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
            Queue<Integer> minHeap = new PriorityQueue<>();
            int mid = A;
            long sum = 0;
            maxHeap.add(mid);
             
            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                 
                if(mid >= X) maxHeap.add(X);
                else minHeap.add(X);
                 
                if(mid >= Y) maxHeap.add(Y);
                else minHeap.add(Y);
                 
                if(maxHeap.size() > minHeap.size() + 1) minHeap.add(maxHeap.poll());
                else if(maxHeap.size() < minHeap.size()) maxHeap.add(minHeap.poll());
                mid = maxHeap.peek();
                sum = (sum + mid) % 20171109;
            }
            sb.append("#").append(test_case).append(" ").append(sum).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}

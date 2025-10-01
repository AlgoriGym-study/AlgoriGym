package Algorithm_Study.common.C202509.C20250924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class SJG0047 {
    static class Jewel implements Comparable<Jewel> {
        int weight;
        int value;
        
        Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
        
        @Override
        public int compareTo(Jewel o) {
            return this.weight - o.weight;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels[i] = new Jewel(m, v);
        }
        
        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(jewels);
        Arrays.sort(bags);
        

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        long totalValue = 0;
        int jewelIdx = 0;
        

        for (int i = 0; i < K; i++) {
            int bagWeight = bags[i];

            while (jewelIdx < N && jewels[jewelIdx].weight <= bagWeight) {
                pq.offer(jewels[jewelIdx].value);
                jewelIdx++;
            }
            
            if (!pq.isEmpty()) {
                totalValue += pq.poll();
            }
        }
        
        System.out.print(totalValue);
    }
}

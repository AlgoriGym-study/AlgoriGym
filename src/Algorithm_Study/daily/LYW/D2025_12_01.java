package Algorithm_Study.daily.LYW;

import java.io.*;
import java.util.*;

public class D2025_12_01 {
    static class Jewel {
        int m; 
        int v; 
        Jewel(int m, int v) { this.m = m; this.v = v; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            int m = sc.nextInt();
            int v = sc.nextInt();
            jewels[i] = new Jewel(m, v);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = sc.nextInt();
        }

        Arrays.sort(jewels, new Comparator<Jewel>() {
            public int compare(Jewel a, Jewel b) {
                if (a.m != b.m) return a.m - b.m;
                return b.v - a.v; 
            }
        });

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        long answer = 0L;
        int idx = 0; 

        for (int i = 0; i < K; i++) {
            int capacity = bags[i];

            while (idx < N && jewels[idx].m <= capacity) {
                pq.offer(jewels[idx].v);
                idx++;
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}

package Algorithm_Study.common.C202509.C20250924;

import java.io.*;
import java.util.*;

public class LYW0047 {
    static class Jewel {
        int m; // 무게
        int v; // 가격
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

        // 보석: 무게 오름차순
        Arrays.sort(jewels, new Comparator<Jewel>() {
            public int compare(Jewel a, Jewel b) {
                if (a.m != b.m) return a.m - b.m;
                return b.v - a.v; // 무게 같으면 비싼 걸 먼저 (옵션)
            }
        });

        // 가방: 용량 오름차순
        Arrays.sort(bags);

        // 가격 최대 힙
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());

        long answer = 0L;
        int idx = 0; // jewels 포인터

        for (int i = 0; i < K; i++) {
            int capacity = bags[i];

            // 현재 가방 용량에 들어갈 수 있는 모든 보석을 힙에 추가
            while (idx < N && jewels[idx].m <= capacity) {
                pq.offer(jewels[idx].v);
                idx++;
            }

            // 가장 비싼 보석 하나 선택
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}

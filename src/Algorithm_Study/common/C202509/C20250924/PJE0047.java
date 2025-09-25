package Algorithm_Study.common.C202509.C20250924;
import java.util.*;
// 백준 보석 도둑
public class PJE0047 {
    static class Jewel {
        int w, v;
        Jewel(int w, int v) {
            this.w = w;
            this.v = v;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();

        Jewel[] jewels = new Jewel[N];
        for (int i = 0; i < N; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            jewels[i] = new Jewel(w, v);
        }

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(jewels, new Comparator<Jewel>() {
            @Override
            public int compare(Jewel j1, Jewel j2) {
                return Integer.compare(j1.w, j2.w);
            }
        });
        Arrays.sort(bags);

        // 최대 가치 보석 뽑기 위한 max-heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long ans = 0;
        int idx = 0; // 보석 배열 인덱스
        for (int cap : bags) {
            // 이 가방에 들어갈 수 있는 모든 보석을 pq에 추가
            while (idx < N && jewels[idx].w <= cap) {
                pq.offer(jewels[idx].v);
                idx++;
            }
            // 가능하다면 가장 가치 높은 보석 하나 꺼내 담는다
            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        System.out.println(ans);
    }
}

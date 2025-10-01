package Algorithm_Study.common.C202509.C20250924;
import java.util.*;
// 백준 보석 도둑
public class PJE0047_2 {
    static class Jewel {
        int m, v; // 무게, 가치
        Jewel(int m, int v){
            this.m = m; this.v = v;    
        } 
        
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
        Arrays.sort(jewels, (a, b) -> Integer.compare(a.m, b.m));
        // 가방: 용량 오름차순
        Arrays.sort(bags);

        // 현재 가방에 들어갈 수 있는 보석들의 '가치'를 최대힙에
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        long ans = 0L;
        int j = 0; // 보석 인덱스

        for (int c : bags) {
            // 이 가방 c에 넣을 수 있는 보석들 추가
            while (j < N && jewels[j].m <= c) {
                maxHeap.offer(jewels[j].v);
                j++;
            }
            // 가장 비싼 보석 하나 선택
            if (!maxHeap.isEmpty()) {
                ans += maxHeap.poll();
            }
        }

        System.out.println(ans);
    }
}

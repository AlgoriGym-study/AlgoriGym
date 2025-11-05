package Algorithm_Study.common.C202509.C20250924;

//백준 1202번 보석 도둑

import java.io.*;
import java.util.*;

public class KMR0047 {

    static class Jewerly implements Comparable<Jewerly> {
        int weight, value;

        Jewerly(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewerly other) {
            return this.weight - other.weight; // 오름차순
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 개수
        Jewerly[] jewels = new Jewerly[N];
        int[] bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken()); // 보석 무게
            int value = Integer.parseInt(st.nextToken()); // 보석 가격
            jewels[i] = new Jewerly(weight, value);
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }// 입력

        Arrays.sort(jewels);
        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 가치 내림차순
        // 우선순위 큐 역할: 가방을 오름차순으로 정렬했을 때, 여태까지 가방에 넣을 수 있는 보석들을 모두 놓아놓은 것이기 때문에
        // idx가 지난 보석이어도 선택할 수 있음(남은 것 중에 고를 수 있다는 것)
        long answer = 0;
        int idx = 0;

        for (int bagWeight : bags) {
            while (idx < N && jewels[idx].weight <= bagWeight) {
                // 보석을 가방에 넣을 수 있으면 pq에 추가
                pq.offer(jewels[idx].value);
                idx++;
            }

            // 가장 가치 높은 보석 선택
            if (!pq.isEmpty()) answer += pq.poll();
        }

        System.out.println(answer);

        br.close();
    }
}

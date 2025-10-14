package Algorithm_Study.common.C202509.C20250924;

// 백준 1202번 보석도둑
import java.util.*;
import java.io.*;

public class KMR0047_2 {

    static class Jewerly implements Comparable<Jewerly>{
        int weight, price;

        public Jewerly(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }

        @Override
        public int compareTo(Jewerly o) {
            return this.weight - o.weight; //오름차순
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 보석의 총 개수
        int K = Integer.parseInt(st.nextToken()); // 가방의 총 개수

        Jewerly[] jewerlyArray = new Jewerly[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            jewerlyArray[i] = new Jewerly(w, p);
        }//보석 저장

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }// 가방 최대 무게 입력

        Arrays.sort(jewerlyArray);
        Arrays.sort(bags); // 가방 무게 오름차순 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // 내림차순

        long answer = 0L;
        int idx = 0;

        for (int bag : bags) {
            // 못 담을 때까지 최대 담기
            while (idx < N && jewerlyArray[idx].weight <=  bag) {
                pq.offer(jewerlyArray[idx].price);
                idx++;
            }
            answer += pq.poll();
        }

        System.out.println(answer);

        br.close();
    }
}

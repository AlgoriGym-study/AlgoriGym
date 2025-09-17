package Algorithm_Study.daily.KMR;

import java.io.*;
import java.util.*;

public class D20250908_SWEA_3000_중간값구하기 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int A = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.comparingInt(a -> -a)); // 처음 ~ 중간값
            PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 중간값보다 큰 값

            maxHeap.offer(A);

            long sum = 0L;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (a > b) {
                    int temp = a;
                    a = b;
                    b = temp;
                }// 작은 값이 a

                maxHeap.offer(a);
                minHeap.offer(b);

                if (maxHeap.peek() > minHeap.peek()) {
                    int x = maxHeap.poll();
                    int y = minHeap.poll();
                    maxHeap.offer(y);
                    minHeap.offer(x);
                }// 값 바꾸기

                sum += maxHeap.peek();
            }

            int answer = (int) (sum % 20171109);
            System.out.printf("#%d %d\n", tc, answer);
        }// tc

        br.close();
    }// main
}

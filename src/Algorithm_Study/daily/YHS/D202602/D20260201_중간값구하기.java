package Algorithm_Study.daily.YHS.D202602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D20260201_중간값구하기 {
    static final int MOD = 20171109;
    static int total;
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t <= tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int mid = Integer.parseInt(st.nextToken());

            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            total = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 2; j++) {
                    int num = Integer.parseInt(st.nextToken());

                    if (num > mid) minHeap.add(num);
                    else maxHeap.add(num);
                }

                if (minHeap.size() > maxHeap.size()) {
                    int item = minHeap.poll();
                    maxHeap.add(mid);
                    mid = item;
                } else if (maxHeap.size() > minHeap.size()) {
                    int item = maxHeap.poll();
                    minHeap.add(mid);
                    mid = item;
                }

                total += mid;
                total %= MOD;
            }

            System.out.println("#" + t + " " + total);
        }
    }
}

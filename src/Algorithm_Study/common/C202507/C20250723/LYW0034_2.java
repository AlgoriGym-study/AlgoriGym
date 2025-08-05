package Algorithm_Study.common.C202507.C20250723;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LYW0034_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            maxHeap.add(num);

            if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }

            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            System.out.println(maxHeap.peek());
        }
    }
}

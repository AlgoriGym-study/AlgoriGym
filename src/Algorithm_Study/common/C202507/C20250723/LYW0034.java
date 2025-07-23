package Algorithm_Study.common.C202507.C20250723;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class LYW0034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); // 최대 힙 (작은 값들)
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(); // 최소 힙 (큰 값들)

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            // 1. maxHeap에 넣기
            maxHeap.add(num);

            // 2. maxHeap에서 가장 큰 값을 minHeap에 옮기기
            if (!maxHeap.isEmpty() && !minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
                minHeap.add(maxHeap.poll());
            }

            // 3. 두 힙의 크기 균형 맞추기 (maxHeap이 항상 같거나 1 더 크도록)
            if (maxHeap.size() < minHeap.size()) {
                maxHeap.add(minHeap.poll());
            }

            // 4. 가운데 값 출력
            System.out.println(maxHeap.peek());
        }
    }
}

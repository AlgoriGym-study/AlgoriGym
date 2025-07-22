package Algorithm_Study.common.C202507.C20250723;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class YHS0034 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();// 최소힙, 오름차순
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); //최대힙, 내림차순

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            //최소힙과 최대힙의 크기가 같다면(홀수번째 수) 최대힙에 저장
            if (maxHeap.size() == minHeap.size()) maxHeap.offer(num);
            //아니라면(짝수번째 수) 최소힙에 저장
            else minHeap.offer(num);

            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                //최대 힙의 루트노드(0번째 인덱스)가 최소 힙의 루트노드보다 크다면 위치를 바꾼다.
                if (maxHeap.peek() > minHeap.peek()) {
                    int tmp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(tmp);
                }
            }
            //중간값 출력
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}

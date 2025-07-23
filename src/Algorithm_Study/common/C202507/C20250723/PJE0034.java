package Algorithm_Study.common.C202507.C20250723;
import java.util.*;

// 백준 가운데를 말해요
public class PJE0034 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순
        PriorityQueue<Integer> right = new PriorityQueue<>();                          
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();

            // 1. 왼쪽 힙에 먼저 넣기
            if (left.isEmpty() || num <= left.peek()) {
                left.offer(num);
            } else {
                right.offer(num);
            }

            // 2. 힙 크기 균형 맞추기
            if (left.size() > right.size() + 1) {
                right.offer(left.poll());
            } else if (right.size() > left.size()) {
                left.offer(right.poll());
            }

            // 3. 중간값 추가
            sb.append(left.peek()).append("\n");
        }

        System.out.print(sb.toString());
    }
}

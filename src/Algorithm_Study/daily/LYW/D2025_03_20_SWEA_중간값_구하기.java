package Algorithm_Study.daily.LYW;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

class D2025_03_20_SWEA_중간값_구하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(); // 테스트 케이스 개수
        int MOD = 20171109;  // 나머지를 구할 수

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt(); // N번의 추가 연산
            int A = sc.nextInt(); // 처음에 적은 숫자
            long sum = 0; // 중간값의 합

            // 최대 힙 (중간값 이하를 저장)
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
            // 최소 힙 (중간값 초과를 저장)
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            // 처음 숫자는 최대 힙에 넣음
            maxHeap.add(A);

            for (int i = 0; i < N; i++) {
                int num1 = sc.nextInt();
                int num2 = sc.nextInt();

                // 새로운 숫자 2개를 중간값 기준으로 정렬하여 삽입
                if (num1 > maxHeap.peek()) {
                    minHeap.add(num1);
                } else {
                    maxHeap.add(num1);
                }

                if (num2 > maxHeap.peek()) {
                    minHeap.add(num2);
                } else {
                    maxHeap.add(num2);
                }

                // 두 개의 힙 크기 균형 맞추기
                if (maxHeap.size() > minHeap.size() + 1) {
                    minHeap.add(maxHeap.poll());
                } else if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                }

                // 중간값은 maxHeap의 루트 값
                int median = maxHeap.peek();
                sum = (sum + median) % MOD;
            }

            System.out.println("#" + tc + " " + sum);
        }
        sc.close();
    }
}

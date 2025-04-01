package Algorithm_Study.daily.CSY.March;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D20250320_중간값_구하기 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= T; tc++) {

            int N = sc.nextInt();// N개의 줄
            int ans = 0;

            // maxheap이 처음값보다 작은 애들 : 오름차순
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

            // minheap이 처음값보다 큰 애들 : 내림차순
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();

            int cp = sc.nextInt(); // 첫 번째 수(첫 비교값)

            for (int i = 0; i < N; i++) {
                // 입력값이 맥스힙의 루프보다 크면 맥스힙에 넣기
                int a = sc.nextInt();
                int b = sc.nextInt();

                if (cp < a) {
                    minHeap.add(a);
                } else {
                    maxHeap.add(a);
                }

                if (cp < b) {
                    minHeap.add(b);
                } else {
                    maxHeap.add(b);
                }


                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(cp); // 비교값 넣어주기
                    cp = minHeap.poll(); // 중간값 갱신
                } else if(minHeap.size() < maxHeap.size()) {
                    minHeap.add(cp); // 비교값 넣어주기
                    cp = maxHeap.poll(); // 중간값 갱신
                }
                ans = (ans + cp) % 20171109;
            } // N forloop

            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb.toString());

    }

}
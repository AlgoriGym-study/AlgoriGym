package Algorithm_Study.common.C202503.C20250328;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class CSY {

        static List<Integer>[] list;
        static List<Integer>[] reverseList;
        static int N;
        static boolean[] big;
        static boolean[] small;

        public static void main(String[] args) {
//		long start = System.currentTimeMillis();
            Scanner sc = new Scanner(System.in);

            N = sc.nextInt(); // 노드 수(학생 수)
            int M = sc.nextInt(); // 간선 수

            // 인접 리스트로 구현, 수가 1부터 시작해서 인덱스 맞추기 위해 M+1
            list = new ArrayList[N + 1];
            reverseList = new ArrayList[N + 1];
            for (int i = 0; i < N + 1; i++) {
                list[i] = new ArrayList<>();
                reverseList[i] = new ArrayList<>();
            } // 각 객체 생성


            for (int i = 1; i < M + 1; i++) {
                int A = sc.nextInt();
                int B = sc.nextInt();

                list[A].add(B); // 유향이니 하나만 표현
                reverseList[B].add(A); // 유향이니 하나만 표현

//			System.out.println(Arrays.toString(list));
                // [[], [5], [], [4], [2, 6], [4, 2], []]
                // 1 2 3 4 5 6

            }

            int count = 0;
            // 1번을 기준으로, 2번을 기준으로,,,.. N번을 기준으로까지 비교해서 count
            for (int i = 1; i < N + 1; i++) {
                big = new boolean[N + 1];
                small = new boolean[N + 1];

                addBig(i);
                addSmall(i);

                int sum = 0;

                for (int k = 1; k < N + 1; k++) {
                    if (big[k])
                        sum++;
                    if (small[k])
                        sum++;
                }

                if (sum == N - 1)
                    count++;
            }

            System.out.println(count);
//		long end = System.currentTimeMillis();
//        System.out.println("실행 시간: " + (end - start) + "ms");

        }// main

        static void addBig(int idx) {
            // i번의 인덱스가 비어있지 않으면 i보다 큰 원소가 존재한다는 뜻
            if (!list[idx].isEmpty()) {
                for (int b : list[idx]) {
                    if (big[b])
                        continue;
                    big[b] = true;
                    addBig(b);
                }
            }
        }// addBig

        static void addSmall(int idx) {

            for(int r : reverseList[idx]) {
                if(small[r]) continue;
                small[r] = true;
                addSmall(r);
            }
            // small 에 넣기 위한 for 문
//		for (int j = 1; j < N + 1; j++) {
            // 만약 리스트에 idx보다 작은 애들이 있다면 small에 추가

//			if(small[j]) continue;
//			for(int l : list[j]) {
//				if(l != idx) continue;
//				small[j] = true;
//
//				addSmall(j);
//			} //1931ms

//			if (list[j].contains(idx)) {
//					if (small[j])
//						continue;
//					small[j] = true;
//					addSmall(j);
//			} // 2115ms
//		}
        }

    }


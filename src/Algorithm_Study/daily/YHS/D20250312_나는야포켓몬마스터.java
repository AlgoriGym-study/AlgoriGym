import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Deque<int[]> dq = new LinkedList<>(); // 문서 인덱스, 중요도 저장
            List<Integer> priority = new ArrayList<>(); // 중요도 리스트 (정렬 가능)

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int p = Integer.parseInt(st.nextToken());
                dq.add(new int[]{i, p}); // 인덱스, 중요도 저장
                priority.add(p); // 중요도 리스트 추가
            }

            priority.sort(Collections.reverseOrder()); // 중요도 내림차순 정렬
            int count = 0, index = 0; // index: 현재 가장 높은 중요도를 가리킴

            while (!dq.isEmpty()) {
                int[] front = dq.poll(); // 문서 정보 가져오기
                int idx = front[0], value = front[1];

                if (value == priority.get(index)) { // 현재 가장 높은 중요도와 일치
                    count++;
                    index++; // 다음 높은 중요도로 이동

                    if (idx == M) { // 목표 문서가 출력된 경우 종료
                        sb.append(count).append("\n");
                        break;
                    }
                } else {
                    dq.addLast(front); // 중요도가 낮으면 다시 뒤로 보냄
                }
            }
        }
        System.out.print(sb); // 최종 출력
    }
}

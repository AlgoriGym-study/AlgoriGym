package Algorithm_Study.common.C202506.C20250625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class CSY0027 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" "); // 입력 받기
        int N = Integer.parseInt(input[0]); // 수빈 위치
        int K = Integer.parseInt(input[1]); // 동생 위치
        int max = 100001;
        int[] time = new int[max]; // 시간 배열
        Arrays.fill(time, -1);

        Deque<Integer> dq = new LinkedList<>(); // bfs로 최단 시간 구하기
        dq.add(N); // 수빈 위치 넣기
        time[N] = 0;

        while(!dq.isEmpty()){
            int cur = dq.poll();

            // 순간이동
            if(cur * 2 < max && time[cur*2] == -1){
                time[cur*2] = time[cur];
                dq.addFirst(cur*2);
            }

            // 걷기
            if (cur - 1 >= 0 && time[cur - 1] == -1) {
                time[cur - 1] = time[cur] + 1;
                dq.addLast(cur - 1);
            }
            if (cur + 1 < max && time[cur + 1] == -1) {
                time[cur + 1] = time[cur] + 1;
                dq.addLast(cur + 1);
            }

        }

        System.out.println(time[K]);
    }
}

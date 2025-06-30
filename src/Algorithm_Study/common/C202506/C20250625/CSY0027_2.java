package Algorithm_Study.common.C202506.C20250625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class CSY0027_2 {

    static int N, K;
    static int[] time; // 시간 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer input = new StringTokenizer(br.readLine());

        N = Integer.parseInt(input.nextToken()); // 수빈이 위치
        K = Integer.parseInt(input.nextToken()); // 동생 위치
        time = new int[100_001];
        Arrays.fill(time, -1); // -1로 채우기

        bfs();
        System.out.println(time[K]);
    }

    static void bfs(){
        Deque<Integer> dq = new LinkedList<>();
        time[N] = 0; // 수빈이 위치 0초
        dq.add(N); // 수빈이 시작점 추가

        while(!dq.isEmpty()){
            int cur = dq.poll();
            // 걷기
            if(cur - 1 >= 0 && time[cur - 1] == -1){ // x-1로 이동하고, 방문한 적 없는 곳이면
                time[cur - 1] = time[cur] + 1; // 방문 체크
                dq.addLast(cur-1);
            }else if(cur + 1 < 100_001 && time[cur + 1] == -1){ // x+1로 이동하고, 방문한 적 없는 곳이면
                time[cur + 1] = time[cur] + 1;
                dq.addLast(cur + 1);
            }

            // 순간 이동
            if(cur * 2 < 100_001 && time[2 * cur] == -1){
                time[2 * cur] = time[cur];
                dq.addFirst(2 * cur);
            }
        }

    }
}

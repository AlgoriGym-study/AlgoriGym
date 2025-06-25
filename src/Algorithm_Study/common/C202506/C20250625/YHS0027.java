package Algorithm_Study.common.C202506.C20250625;

import java.io.*;
import java.util.*;

public class YHS0027 {
    static final int MAX = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[MAX+1];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{N, 0});

        int ans = Integer.MAX_VALUE;

        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            int curr = tmp[0];
            int time = tmp[1];
            visited[curr] = true;

            //동생의 위치에 도달하면 종료
            if (curr == K) {
                ans = Math.min(ans, time);
            }

            //가능한 이동
            if (curr * 2 <= MAX && !visited[curr * 2]) {
                q.offer(new int[]{curr * 2, time});
            }
            if (curr + 1 <= MAX && !visited[curr + 1]) {
                q.offer(new int[]{curr + 1, time + 1});
            }
            if (curr - 1 >= 0 && !visited[curr - 1]) {
                q.offer(new int[]{curr - 1, time + 1});
            }
        }
        System.out.println(ans);
    }
}

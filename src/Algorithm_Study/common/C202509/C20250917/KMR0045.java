package Algorithm_Study.common.C202509.C20250917;

import java.io.*;
import java.util.*;

public class KMR0045 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] times = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            times[i] = Long.parseLong(st.nextToken());
        }// 입력

        Arrays.sort(times);

        long left = 1;
        long right = 1_000_000_000 + 1; // left < right이므로 답이 10억일때를 놓치게 된다.
        long answer = Long.MAX_VALUE;

        while (left < right) {
            long mid = (left + right) / 2;

            if (canSolve(times, mid)) {
                right = mid;
                answer = Math.min(answer, mid); // 이분탐색: 현재까지 정답 후보 중 가장 작은 값을 저장
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);

        br.close();
    }

    static boolean canSolve(long[] times, long gap) {
        long result = 0;
        for (int i = 0; i < times.length; i++) {
            result += times[i] / gap;
            if (times[i] % gap != 0) result++; // 올림계산: 간격을 얼마나 차지하는지 계산
        }

        long blank = 2L * times.length; // 채울 수 있는 칸의 수

        if (result < blank) return true;
        // 왜 같을때는 안될까? -> 다음 간격까지 두 트랙 중 작은 트랙을 채운다 -> 무조건 작은쪽은 긴쪽이 된다.
        // 항상 다음 간격을 채우려고 하기 때문에 두 트랙은 같을 수 없다.
        // 그렇기에 꽉찰 수 없다.
        return false;
    }
}
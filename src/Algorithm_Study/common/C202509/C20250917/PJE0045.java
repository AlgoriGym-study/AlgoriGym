package Algorithm_Study.common.C202509.C20250917;

import java.util.*;

public class PJE0045 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] inp = new long[N];
        for (int i = 0; i < N; i++) {
            inp[i] = sc.nextLong();
        }

        Arrays.sort(inp);

        long l = 1L, r = 1_000_000_000L;
        while (l <= r) {
            // mid: 문제를 푼 뒤 다음 완료까지 허용하는 최대 간격(검사 값)
            long mid = (l + r) / 2;

            // 가장 긴 문제부터(마지막 원소) 시작
            long a = ((inp[N - 1] + (mid - 1)) / mid) * mid; // ceil(inp[N-1]/mid) * mid
            long b = 0L;

            boolean f = true;  // 가능 여부 플래그
            int ll = 0;
            int rr = N - 2;

            while (ll <= rr && f) {
                if (a - b == mid) {
                    // SWAP(a, b)
                    long tmp = a; a = b; b = tmp;
                    a += ((inp[rr] + (mid - 1)) / mid) * mid; // 가장 큰 남은 문제 추가
                    rr--;
                } else {
                    if ((inp[ll] + (mid - 1)) / mid > 1) {
                        f = false; // 짧은 문제도 mid 1칸에 못 넣으면 실패
                    } else {
                        ll++;
                        b += mid; // 짧은 문제 하나를 b쪽에 배치(간격 mid 한 칸 차지)
                    }
                }
            }

            if (!f || a - b > mid) {
                l = mid + 1; // 불가능 → 더 큰 간격 탐색
            } else {
                r = mid - 1; // 가능 → 더 작은 간격 시도
            }
        }

        System.out.println(l);
    }
}

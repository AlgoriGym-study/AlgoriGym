package Algorithm_Study.daily.PJE.D202509;
import java.util.*;
// 프로그래머스 공원
public class D20250918 {
   public int solution(int[] mats, String[][] park) {
        int n = park.length;
        int m = park[0].length;

        // 사람 앉아있으면 1, 아니면 0
        int[][] occ = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                occ[i][j] = park[i][j].equals("-1") ? 0 : 1;
            }
        }

        // 2D prefix sum 배열 만들기
        int[][] psum = new int[n + 1][m + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                psum[i][j] = occ[i-1][j-1]
                           + psum[i-1][j]
                           + psum[i][j-1]
                           - psum[i-1][j-1];
            }
        }

        // mats를 내림차순으로 정렬 (큰 돗자리부터 시도)
        Arrays.sort(mats);
        for (int idx = mats.length - 1; idx >= 0; idx--) {
            int k = mats[idx];
            if (k > n || k > m) continue; // 공원보다 큰 돗자리는 불가능

            // 모든 시작 좌표에서 k×k 검사
            for (int i = 0; i + k <= n; i++) {
                for (int j = 0; j + k <= m; j++) {
                    if (isEmpty(psum, i, j, i + k - 1, j + k - 1)) {
                        return k; // 바로 리턴
                    }
                }
            }
        }

        return -1;
    }

    // 영역 (r1,c1) ~ (r2,c2)가 전부 비었는지 확인
    private boolean isEmpty(int[][] psum, int r1, int c1, int r2, int c2) {
        int sum = psum[r2+1][c2+1]
                - psum[r1][c2+1]
                - psum[r2+1][c1]
                + psum[r1][c1];
        return sum == 0;
    }

}

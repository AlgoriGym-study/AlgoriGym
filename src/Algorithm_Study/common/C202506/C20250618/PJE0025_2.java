package Algorithm_Study.common.C202506.C20250618;
import java.util.*;
// 프로그래머스 비밀코드 해독
public class PJE0025_2 {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        // 오름차순 조합 배열 구하기
        for(int a = 1; a < n-3; a++){
            for(int b = a+1; b<n-2; b++){
                for(int c = b+1; c<n-1; c++){
                    for(int d = c+1; d<n; d++){
                        for(int e = d+1; e<n+1; e++){
                            set.clear();
                            set.add(a);
                            set.add(b);
                            set.add(c);
                            set.add(d);
                            set.add(e);
                            // 만들어진 조합 배열로 조건에 맞는지 확인
                            if (check(set, q, ans)) {
                                answer++;
                            }
                        }
                    }
                }
            }
        }

        return answer;
    }
    // 만들어진 조합이 각 q(시도)와 ans(일치개수)에 대해 부합하는지 확인 
    private boolean check(Set<Integer> set, int[][] q, int[] ans) {
        for (int i = 0; i < q.length; i++) {
            int cnt = 0;
            for (int j = 0; j < 5; j++) {
                if (set.contains(q[i][j])) cnt++;
            }
            if (cnt != ans[i]) {
                return false;
            }
        }
        return true;
    }
}

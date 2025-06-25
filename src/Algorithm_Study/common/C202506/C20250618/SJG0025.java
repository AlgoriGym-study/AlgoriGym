package Algorithm_Study.common.C202506.C20250618;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SJG0025 {
    // 모든 가능한 5개 조합을 저장할 리스트
    private List<List<Integer>> combs;
    // 1부터 n까지 숫자를 사용하므로 n을 멤버 변수로 저장
    private int n;
    
    public int solution(int n, int[][] q, int[] ans) {
        this.n = n;
        this.combs = new ArrayList<>();
        
        // 1~n 중에서 5개를 선택하는 모든 조합을 생성
        makeComb(new ArrayList<>(), 1, 5);
        
        int count = 0;
        // 생성된 모든 조합에 대해 정답 조건을 만족하는지 확인
        for (List<Integer> comb : combs) {
            if (isValidComb(comb, q, ans)) {
                count++;  // 모든 시도(q)와 응답(ans)에 대해 일치하면 개수 증가
            }
        }
        
        return count;
    }
    
    // n개 수 중에서 remaining개를 조합으로 선택하여 combs에 추가
    // curr:      현재까지 선택한 숫자들
    // start:     이번에 선택할 수 있는 최소 숫자
    // remaining: 남은 선택 개수
    private void makeComb(List<Integer> curr, int start, int remaining) {
        // 남은 선택 개수가 0이면 현재 조합 완성
        if (remaining == 0) {
            combs.add(new ArrayList<>(curr));
            return;
        }
        
        // i를 start부터 시작해서 n-remaining+1까지 증가시키며 숫자 선택
        // n-remaining+1을 넘어가면 뒤에 남은 개수를 채울 수 없으므로 멈춤
        for (int i = start; i <= n - remaining + 1; i++) {
            curr.add(i);                            // i를 조합에 추가
            makeComb(curr, i + 1, remaining - 1);   // 다음 숫자를 i+1 이상에서 고르고, remaining-1개 남김
            curr.remove(curr.size() - 1);           // 백트래킹
        }
    }
    
    // 하나의 조합이 모든 시도와 응답 조건을 만족하는지 검사
    // comb: 조합된 5개 숫자 리스트
    // q:    각 시도에서 입력한 5개 숫자들의 배열 모음
    // ans:  각 시도에서 시스템이 응답한 일치 개수 배열
    private boolean isValidComb(List<Integer> comb, int[][] q, int[] ans) {
        // HashSet을 이용해 중복없이 포함여부 체크
        Set<Integer> secretCode = new HashSet<>(comb);
        
        // 각 시도에 대해 반복문 순회
        for (int i = 0; i < q.length; i++) {
            int matchCount = 0;
            
            // q[i]에 담긴 5개의 숫자를 하나씩 꺼내서 확인
            for (int num : q[i]) {
                // 만약 secretCode에 포함되어 있으면 개수 증가
                if (secretCode.contains(num)) {
                    matchCount++;
                }
            }
            
            // 시스템 응답(ans[i])과 실제 matchCount가 다르면 유효 조합이 아님
            if (matchCount != ans[i]) {
                return false;
            }
        }
        
        // 모든 시도에서 응답이 일치하면 유효 조합
        return true;
    }
}

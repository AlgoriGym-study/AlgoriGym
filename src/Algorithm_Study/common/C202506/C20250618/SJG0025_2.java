package Algorithm_Study.common.C202506.C20250618;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SJG0025_2 {
    public int solution(int n, int[][] q, int[] ans) {
        List<List<Integer>> validCombinations = new ArrayList<>();
        
        // 조합 생성과 동시에 검증
        generateAndValidate(new ArrayList<>(), 1, 5, n, q, ans, validCombinations);
        
        return validCombinations.size();
    }
    
    // 조합 생성과 검증을 동시에 수행
    private void generateAndValidate(List<Integer> current, int start, int remaining,
                                   int n, int[][] q, int[] ans, 
                                   List<List<Integer>> validCombinations) {
        // 조합 완성시 검증
        if (remaining == 0) {
            if (isValidCombination(current, q, ans)) {
                validCombinations.add(new ArrayList<>(current));
            }
            return;
        }
        
        // 조합 생성
        for (int i = start; i <= n - remaining + 1; i++) {
            current.add(i);
            generateAndValidate(current, i + 1, remaining - 1, n, q, ans, validCombinations);
            current.remove(current.size() - 1);
        }
    }
    
    // 조합이 모든 질의 조건을 만족하는지 검증
    private boolean isValidCombination(List<Integer> combination, int[][] q, int[] ans) {
        Set<Integer> secretCode = new HashSet<>(combination);
        
        for (int i = 0; i < q.length; i++) {
            int matchCount = 0;
            
            for (int num : q[i]) {
                if (secretCode.contains(num)) {
                    matchCount++;
                }
            }
            
            if (matchCount != ans[i]) {
                return false;
            }
        }
        
        return true;
    }
}

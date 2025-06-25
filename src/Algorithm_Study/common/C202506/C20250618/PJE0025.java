package Algorithm_Study.common.C202506.C20250618;
import java.util.*;

// 프로그래머스 비밀 코드 해독
class PJE0025 {
    public int solution(int n, int[][] q, int[] ans) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        // 5개 오름차순 조합 배열 구하기 
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
                            
                            // 구해진 조합에 대해 조건 확인
                            boolean isValid = true;
                            for(int i = 0; i <q.length; i++){
                                int cnt = 0;
                                for(int j = 0; j < q[0].length; j++){
                                    if(set.contains(q[i][j])) cnt++;
                                }
                                if(cnt != ans[i]){
                                    isValid = false;
                                    break;
                                }
                            }
                            if(isValid) answer++;
                        }
                    }
                }
            }
        }

        return answer;
    }
}

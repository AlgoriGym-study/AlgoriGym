package Algorithm_Study.common.C202506.C20250618;

import java.util.ArrayList;
import java.util.List;

public class CSY0025_2 {
    static int res;

    public static void main(String[] args) {
        int n = 10;
        int[][] q = {{1, 2, 3, 4, 5}, {6, 7, 8, 9, 10}, {3, 7, 8, 9, 10},{2, 5, 7, 9, 10}, {3, 4, 5, 6, 7}};
        int[] ans = {2, 3, 4, 3, 3};

        res = 0;
        List<Integer> code = new ArrayList<>();
        dfs(1, code, n, q, ans);

        System.out.println(res);
    }

    static void dfs(int start, List<Integer> code, int n, int[][] q, int[] ans){
        if(code.size() == 5){ // 서로 다른 정수 5개가 모이면 검사
            if(validate(code, q, ans)) res++;
            return;
        }
        for(int i = start; i <=n; i++){
            code.add(i);
            dfs(i+1, code, n, q, ans);
            code.remove(code.size() -1);
        }
    }

    static boolean validate(List<Integer> code, int[][] q, int[] ans){
        for(int i = 0; i < q.length; i++){ // 각 q별로 ans의 수와 맞는지 체크
            int cnt = 0;
            for(int x : q[i]){
                if(code.contains(x)) cnt++;
            }
            if(cnt != ans[i]) return false;
        }
        return true;
    }
}

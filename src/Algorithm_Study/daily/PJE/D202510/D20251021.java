package Algorithm_Study.daily.PJE.D202510;
import java.util.*;

//프로그래머스 최소직사각형
public class D20251021 {
    public int solution(int[][] sizes) {
        
        int max = 0;
        int max2 = 0;
        
        int arrLen = sizes.length; // 사이즈 배열의 길이 
        for(int i = 0; i < arrLen; i++){
            Arrays.sort(sizes[i]);
            
            if( max < sizes[i][0]) 
                max = sizes[i][0];
            if( max2 < sizes[i][1]) 
                max2 = sizes[i][1];
        }
        
        return max*max2;
    }
}

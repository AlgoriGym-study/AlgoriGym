package Algorithm_Study.daily.PJE.D202602;
import java.util.*;
class Solution {
    public int solution(int[] arr) {
        int answer = 0;
     while (true) {
            boolean changed = false;
            for (int i = 0; i < arr.length; i++) {
                int origin = arr[i];
                if (arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                }

                // 이전 값과 하나라도 다르면 표시
                if (origin != arr[i]) changed = true;
            }

            if (!changed) break; // 변한 게 없다면 반복 끝내기
            answer++;
        }
        
        
        return answer;
    }
}

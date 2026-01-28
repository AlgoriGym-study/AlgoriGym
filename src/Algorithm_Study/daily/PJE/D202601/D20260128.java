package Algorithm_Study.daily.PJE.D202601;
import java.util.Arrays;
public class D20260128 {
    // 슬라이딩 윈도우 개념으로 풀이
    public int[] solution(int[] num_list, int n) {
        int len = num_list.length;
        int[] result = new int[len];

        // 1. 뒤쪽 윈도우 (인덱스 n부터 끝까지)를 결과의 맨 앞으로 복사
        int[] back = Arrays.copyOfRange(num_list, n, len);
        // 2. 앞쪽 윈도우 (인덱스 0부터 n-1까지)를 그 뒤로 복사
        int[] front = Arrays.copyOfRange(num_list, 0, n);

        // 두 배열 합치기
        System.arraycopy(back, 0, result, 0, back.length);
        System.arraycopy(front, 0, result, back.length, front.length);

        return result;
    }
    
    // 직관적 풀이
//     public int[] solution(int[] num_list, int n) {
//         int[] answer = new int [num_list.length];
        
//         // n 이후 원소들 +  n 까지의 원소들
//         int idx = 0; 
//         for(int i = n; i < num_list.length; i++){
//             answer[idx++] = num_list[i];
//         }
        
//         for(int i = 0; i < n; i++){
//             answer[idx++] = num_list[i];
//         }
//         return answer;
//     }
}

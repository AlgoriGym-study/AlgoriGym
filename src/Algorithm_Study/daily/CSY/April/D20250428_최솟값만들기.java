package Algorithm_Study.daily.CSY.April;
import java.util.*;

public class D20250428_최솟값만들기 {
        public int solution(int []A, int []B)
        {
            int answer = 0;
            Arrays.sort(A);
            Arrays.sort(B);

            for(int i = 0; i < A.length; i++){
                int a = A[i] * B[B.length-i-1];
                answer += a;
            }

            // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
            System.out.println(Arrays.toString(B));

            return answer;
        }
}

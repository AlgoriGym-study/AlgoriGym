package Algorithm_Study.daily.PJE.D202605;
import java.util.*;

public class D20260526 {
    public int solution(int n) {
        int ans = 0; // 배터리

        while( n > 0){
            if(n%2 != 0){ // 홀수면 점프가 필요함
                ans++; // 배터리 증가
                n--; // 짝수로 만들기
            }
            n /= 2; // 짝수면 순간이동 가능하므로 2로 나눔
        }

        return ans;
    }
}

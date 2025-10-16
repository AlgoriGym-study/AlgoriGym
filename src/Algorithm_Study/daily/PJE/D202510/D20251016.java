package Algorithm_Study.daily.PJE.D202510.D20251016;
import java.util.*;

public class D20251016 {
    public int solution(int n, int a, int b) {
        int round = 0;
        while (a != b) {
            // 다음 라운드의 번호 = ceil(x/2) == (x + 1) / 2
            a = (a + 1) / 2;
            b = (b + 1) / 2;
            round++;
        }
        return round;
    }
}

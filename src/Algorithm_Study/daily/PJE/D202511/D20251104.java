package Algorithm_Study.daily.PJE.D202511;
import java.util.*;

public class D20251104 {
    public int solution(String[][] clothes) {
        Map<String, Integer> byType = new HashMap<>();
        for (String[] c : clothes) {
            String type = c[1];
            byType.put(type, byType.getOrDefault(type, 0) + 1);
        }

        long ways = 1; // 곱셈 중간값 안전히
        for (int cnt : byType.values()) {
            ways *= (cnt + 1); // 그 종류에서 1개 고르기 + 안 입기
        }
        return (int)(ways - 1); // 모두 안 입는 경우 제외
    }
}

package Algorithm_Study.daily.PJE.D202512;
import java.util.*;

public class D20251222 {
    Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        boolean[] used = new boolean[numbers.length()];

        // 숫자 만들기 시작
        makeNumbers(numbers, used, "");

        int answer = 0;
        for (int n : set) {
            if (isPrime(n)) answer++;
        }
        return answer;
    }

    // 숫자를 하나씩 붙여가며 모든 경우 생성
    void makeNumbers(String numbers, boolean[] used, String current) {
        if (!current.equals("")) {
            set.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (used[i]) continue;

            used[i] = true;
            makeNumbers(numbers, used, current + numbers.charAt(i));
            used[i] = false;
        }
    }

    // 소수 판별
    boolean isPrime(int n) {
        if (n < 2) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
}

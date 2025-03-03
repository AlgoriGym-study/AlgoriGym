package Algorithm_Study.daily.LYW;
import java.util.Scanner;

public class D2025_03_02_백준2775_부녀회장이_될테야 {
    // 재귀 함수로 거주민 수 계산
    public static int func(int k, int n) {
        if (k == 0) return n; // 0층의 i호에는 i명이 산다
        if (n == 1) return 1; // 모든 층의 1호에는 1명이 산다
        // func(k - 1, n) -> 바로 아래 층(k-1)의 같은 호(n)의 사람 수.
        // func(k, n - 1) -> 같은 층(k)에서 바로 왼쪽(n-1)의 사람 수.
        // 두 개를 더한 값이 해당 호실(k층 n호)에 사는 사람 수가 된다.
        return func(k - 1, n) + func(k, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int T = sc.nextInt();
        
        for (int tc = 0; tc < T; tc++) {
            int k = sc.nextInt(); // 층
            int n = sc.nextInt(); // 호
            
            System.out.println(func(k, n));
        }
        
    }
}

package Algorithm_Study.daily.PJE;
import java.util.Scanner;

public class D20250313 {
	static int N;
    static int[] queen;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            queen = new int[N];
            answer = 0;
            putQueen(0);
            System.out.println("#" + tc + " " + answer);
        }
    }

    private static void putQueen(int level) {
        if (level == N) { // 모든 퀸을 배치한 경우
            answer++;
            return;
        }

        for (int i = 0; i < N; i++) {
            queen[level] = i; 

            boolean isValid = true;
            for (int j = 0; j < level; j++) {
                // 같은 열 혹은 대각선 충돌 검사
                if (queen[level] == queen[j] || Math.abs(level - j) == Math.abs(queen[level] - queen[j])) {
                    isValid = false;
                    break;
                }
            }

            if (isValid) {
                putQueen(level + 1);
            }
        }
    }
}

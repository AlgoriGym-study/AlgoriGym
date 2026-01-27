package Algorithm_Study.daily.LYW;
import java.util.Scanner;

public class D2026_01_22 {
	
	static int[] score;
    static int[] cal;
    static int L;
    static int N;
    static int maxscore;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
 
        int T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            L = sc.nextInt();
            score = new int[N];
            cal = new int[N];
            maxscore = 0;
 
            for (int i = 0; i < N; i++) {
                score[i] = sc.nextInt();
                cal[i] = sc.nextInt();
            }
            func(0, 0, 0);
            System.out.println("#" + tc + " " + maxscore);
        }
    }
 
    public static void func(int idx, int calsum, int scoresum) {
        if (calsum > L) {
            return;
        }
        if (idx == N) {
            if (maxscore < scoresum) {
                maxscore = scoresum;
            }
            return;
        }
        func(idx + 1, calsum + cal[idx], scoresum + score[idx]);
        func(idx + 1, calsum, scoresum);
    }

}

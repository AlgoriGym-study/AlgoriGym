package Algorithm_Study.daily.CSY.March;

import java.util.Scanner;

public class D20250306_햄버거 {
    // 편한 함수 사용을 위한 변수들  스테틱 선언
//	static Map<Integer, Integer> map;
    static int N;
    static int L;
    static int[] scores;
    static int[] kcal;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        String s = "";

        for(int tc = 1; tc <= T; tc++) {

            N = sc.nextInt(); // 재료의 수
            L = sc.nextInt(); // 칼로리 제한
            //map = new HashMap<>(); // 재료 점수, 칼로리
            scores = new int[N];
            kcal = new int[N];

            for(int i = 0; i < N; i++) {
                //map.put(sc.nextInt(), sc.nextInt());
                scores[i] = sc.nextInt();
                kcal[i] = sc.nextInt();
            }

            //System.out.println(map); //{400=400, 100=200, 500=1000, 250=300, 300=500}

            // 로직
            // 부분집합을 해야 함. 재귀함수를 이용해서 부분집합을 하는데,
            // 칼로리의 합이 L이하여야 함.
            // 그것들의 점수의 합을 구해서, 점수가 최대인 것이 답!
            int ans = 0;
            ans = 비트();

            s += "#" + tc + " " + ans + "\n";

        }
        System.out.println(s);
    }

    static int 비트() {
        int ans = 0;

        for(int i = 0; i < (1 << N); i++) { // 총 경우의 수 2의 N승
            int kSum = 0; // 칼로리 합, 경우의 수마다 초기화
            int sSum = 0; // 점수의 합
            for(int j = 0; j < N; j++) { // 하나의 경우의 수(하나씩 체크)
                if((i & 1 << j) != 0) {
//					System.out.print(scores[j]);
                    kSum += kcal[j]; // 해당 집합의 칼로리의 합
                    sSum += scores[j]; // 해당 집합의 점수의
//					System.out.println(kSum + " | " + sSum);
                }
            }
            if(kSum <= L) {
                ans = Math.max(ans, sSum); // 점수 최대값 갱신
            }
//			System.out.println();
        }



        return ans;
    }

}

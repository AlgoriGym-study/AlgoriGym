package Algorithm_Study.daily.CSY.March;

import java.util.Scanner;

public class D20250309_부녀회장이될테야 {
    static int P = 0; // k층 n호에 거주하는 사람들
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String s = "";
        for(int tc = 1; tc <= T; tc++){
            int k = sc.nextInt();
            int n = sc.nextInt();
            P = 0; // 테스트 케이스마다 초기화
            P = countFun(k, n);
            s += P + "\n";
        }
        System.out.println(s);

    }

    static int countFun(int k, int n){

        //  0층부터 있고 각층에는 1호부터 있으며, 0층의 i호에는 i명이 산다
        // k가 1이고, n이 3일 때, 1층에 3호 => 0층의 1호부터 3호까지의 합.
        // 종료 조건
        if(k == 0){
            return n;
        }
        if ( n == 1) {
            return 1;
        }

        // a층의 b호에 살려면 자신의 아래(a-1)층의 1호부터 b호까지 사람들의 수의 합만큼 사람들을 데려와 살아야 한다
        // 재귀 부분
//        for(int i = 1; i <= n; i++){
//            System.out.println("P: " + P +  ", k : " + k + ", i :" + i);
//        }
        return countFun(k-1, n) + countFun(k, n-1);
    }
}

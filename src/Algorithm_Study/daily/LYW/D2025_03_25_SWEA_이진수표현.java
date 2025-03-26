package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_03_25_SWEA_이진수표현 {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
             
            int num = (1 << N) -1;
            if((M & num) == num) {
                System.out.println("#" + tc + " " + "ON");
            }
            else System.out.println("#" + tc + " " + "OFF");
             
        }
         
 
    }
 
}
package D202512;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.print(n + " is ");
        if (n % 2 == 0) System.out.print("even");
        else System.out.print("odd");
    }
}

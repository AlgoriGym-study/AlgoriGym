package Algorithm_Study.daily.LYW;

import java.util.Arrays;
import java.util.Scanner;

public class D2025_11_28 {
    static int[] dwarf = new int[9];
    static int[] selected = new int[7];
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            dwarf[i] = sc.nextInt();
        }

        comb(0, 0);
    }

    static void comb(int idx, int start) {
        if (found) return;  

        if (idx == 7) { 
            int sum = 0;
            for (int i = 0; i < 7; i++) {
                sum += selected[i];
            }
            if (sum == 100) {
                Arrays.sort(selected);  
                for (int i = 0; i < 7; i++) {
                    System.out.println(selected[i]);
                }
                found = true;  
            }
            return;
        }

        for (int i = start; i < 9; i++) {
            selected[idx] = dwarf[i];
            comb(idx + 1, i + 1);
        }
    }
}

package Algorithm_Study.daily.LYR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D20251208 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 1;
        int range = 2;

        int input = Integer.parseInt(br.readLine());
        if(input == 1)
            System.out.println(1);
        else {
            while (range <= input) {
                range = range + (6 * count);
                count++;
            }
            System.out.println(count);
        }
    }
}


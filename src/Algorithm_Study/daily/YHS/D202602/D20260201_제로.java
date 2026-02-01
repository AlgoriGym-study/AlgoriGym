package Algorithm_Study.daily.YHS.D202602;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class D20260201_제로 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= TC; tc++) {
            int K = Integer.parseInt(br.readLine());

            Stack<Integer> stack = new Stack<>();
            int total = 0;

            for (int i = 0; i < K; i++) {
                int num = Integer.parseInt(br.readLine());

                if (num != 0) {
                    stack.push(num);
                    total += num;
                } else {
                    total -= stack.pop();
                }
            }


            System.out.printf("#%d %d\n", tc, total);
        }
    }
}

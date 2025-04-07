package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250406 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());

        // 비트마스크로 사용할 정수
        int S = 0;

        for (int i = 0; i < M; i++) {
            String input[] = br.readLine().split(" ");

            String command = input[0];

            int x = 0;

            switch (command) {
                case "add":
                    x = Integer.parseInt(input[1]);
                    S |= (1 << (x - 1));
                    break;
                case "remove":
                    x = Integer.parseInt(input[1]);
                    S &= ~(1 << (x - 1));
                    break;
                case "check":
                    x = Integer.parseInt(input[1]);
                    if ((S & (1 << (x - 1))) != 0) {
                        sb.append(1).append('\n');
                    } else {
                        sb.append(0).append('\n');
                    }
                    break;
                case "toggle":
                    x = Integer.parseInt(input[1]);
                    S ^= (1 << (x - 1));
                    break;
                case "all":
                    S = (1 << 20) - 1;
                    break;
                case "empty":
                    S = 0;
                    break;
            }
        }

        System.out.print(sb);
        br.close();
    }
}

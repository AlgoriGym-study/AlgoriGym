package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class D20250227 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        sb.append('<');
        
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= N; i++) list.add(i);

        int idx = 0;

        while (!list.isEmpty()) {
            idx = (idx + (K - 1)) % list.size();
            sb.append(list.remove(idx));

            if (!list.isEmpty()) sb.append(", ");
        }
        sb.append('>');

        System.out.println(sb);
    }
}

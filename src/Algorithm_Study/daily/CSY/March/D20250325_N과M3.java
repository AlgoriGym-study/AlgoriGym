package Algorithm_Study.daily.CSY.March;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D20250325_N과M3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        sb = new StringBuilder();
        List<Integer> current = new ArrayList<>();
        curcur(0, current, N, M);
        System.out.println(sb.toString());
    }
    static StringBuilder sb;

    static void curcur(int idx, List<Integer> current, int N, int M) {
        if(current.size() == M) {
            for(int i = 0; i < M; i++) {
                sb.append(current.get(i)).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 1; i <= N; i++) {
            current.add(i);
            curcur(idx+1, current, N, M);
            current.remove(current.size()-1);
        }
    }

}

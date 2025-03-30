import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, K, min;
    static int[] coin;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        coin = new int[N];

        for (int i = 0; i < N; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        min = Integer.MAX_VALUE;
        greedy(0, 0, 0);
        System.out.println(min);
    }

    static void greedy(int depth, int start, int total) {
        if (total > K)
            return;

        if (total == K) {
            min = Math.min(min, depth);

            return;
        }

        for (int i = start; i < N; i++) {
            total += coin[i];
            greedy(depth + 1, i + 1, total);
        }
    }
}

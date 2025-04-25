package Algorithm_Study.daily.YHS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class D20250425_N번째큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] board = new int[N][N];

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken()); // board는 K x K 배열
                if (minHeap.size() < N) {
                    minHeap.add(board[i][j]);
                } else if (board[i][j] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(board[i][j]);
                }
            }
        }

        System.out.println(minHeap.peek());
    }
}

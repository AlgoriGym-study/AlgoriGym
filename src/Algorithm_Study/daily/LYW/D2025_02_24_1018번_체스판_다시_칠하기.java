package Algorithm_Study.daily.LYW;

import java.util.Scanner;

public class D2025_02_24_1018번_체스판_다시_칠하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];

        // 입력값 배열에 넣기
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next().toCharArray();
        }

        int answer = N*M; // 최소 다시 칠해야 하는 개수 저장

        // 8x8 체스판을 선택하는 모든 경우 탐색
        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                int cnt1 = 0; // 'W'로 시작하는 체스판과 비교
                int cnt2 = 0; // 'B'로 시작하는 체스판과 비교

                // 8x8 영역 탐색
                for (int x = 0; x < 8; x++) {
                    for (int y = 0; y < 8; y++) {
                        char current = arr[i + x][j + y];

                        // (x + y) 짝수 위치는 첫 번째 칸과 같은 색이어야 함
                        if ((x + y) % 2 == 0) {
                            if (current != 'W') cnt1++; // 'W' 시작 체스판과 비교
                            if (current != 'B') cnt2++; // 'B' 시작 체스판과 비교
                        } 
                        // (x + y) 홀수 위치는 첫 번째 칸과 다른 색이어야 함
                        else {
                            if (current != 'B') cnt1++; // 'W' 시작 체스판과 비교
                            if (current != 'W') cnt2++; // 'B' 시작 체스판과 비교
                        }
                    }
                }

                // 최소 값 갱신
                answer = Math.min(answer, Math.min(cnt1, cnt2));
            }
        }

        System.out.println(answer);
    }
}

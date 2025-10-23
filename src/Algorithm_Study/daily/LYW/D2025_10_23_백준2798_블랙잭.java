package Algorithm_Study.daily.LYW;
import java.util.Scanner;

public class D2025_10_23_백준2798_블랙잭 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N]; // 펼쳐질 카드 배열
		int answer = 0; // 정답
		int min = M;
		
		// arr에 값 대입
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		// 세 개의 카드의 합이 블랙잭인 M이 되는 경우와 M보다 작은수가 되는 경우를 나누어 판단
		// M이 되는 경우 -> 정답은 M
		// M 보다 작은 경우 -> 전체 경우의 수 중, M - 3카드의 합이 최소인 경우 정답
		first: for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int num = arr[i] + arr[j] + arr[k];
					if (num == M) { // 블랙잭이므로 M이 정답이 된다.
						answer = M;
						break first;
					} else if (num < M) { // M - num이 최소값인 경우가 답이 되므로 완전탐색하면서 최소값을 초기화 하고 그때의 num 값을 기억한다.
						if (M - num < min) {
							min = M - num;
							answer = num;
						}
					}
				}
			}
		}

		System.out.println(answer);

	}
}

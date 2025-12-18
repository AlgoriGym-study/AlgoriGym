package Algorithm_Study.daily.LYW;
import java.util.Scanner;

public class D2025_12_15 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N]; 
		int answer = 0;
		int min = M;
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}

		first: for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) {
				for (int k = j + 1; k < N; k++) {
					int num = arr[i] + arr[j] + arr[k];
					if (num == M) {
						answer = M;
						break first;
					} else if (num < M) { 
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

class JSH {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
//		Scanner sc = new Scanner(new File("input.txt"));

		int T = sc.nextInt();
		sc.nextLine();

		for (int test_case = 1; test_case <= T; test_case++) {

			int N = sc.nextInt();
			int K = sc.nextInt();

			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			Arrays.sort(arr);
			int maxCount = -1;
			int count = 0;

			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j > i; j--) {
					// K가 0이면 1을 반환
					if (K == 0) {
						maxCount = 1;
					}
					// 최대값 - 최소값의 차이가 2 이내인 경우
					if (arr[j] - arr[i] <= K) {
						// 최대값의 인덱스번호인 j와
						// 최소값의 인덱스번호인 i를 빼주고
						// 자기자신은 항상 포함이기에 1을 더해준다
						count = j - i + 1;
						maxCount = Math.max(maxCount, count);
					}
				}
			}
			System.out.println(maxCount);
		}
	}
}
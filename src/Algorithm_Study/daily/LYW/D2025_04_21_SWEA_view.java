package Algorithm_Study.daily.LYW;

import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {

// 입력값 배열에 넣기
			int N = sc.nextInt();
			int[] arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

// 정답을 담을 변수
			int cnt = 0;

// 검사할 빌딩이 앞, 뒤 2칸 거리의 빌딩들 보다 높아야지 조망권이 있는 세대가 있다.
//  조망권을 가진 세대 수 = 검사할 빌딩 - 앞, 뒤 2칸 거리의 빌딩 중 가장 높은 빌딩
			for (int a = 2; a < N - 2; a++) {
// 검사할 빌딩 층 수 - 거리별 빌딩 층 수
				int a1 = arr[a] - arr[a - 1];
				int a2 = arr[a] - arr[a - 2];
				int a3 = arr[a] - arr[a + 1];
				int a4 = arr[a] - arr[a + 2];

// 층 수가 양수인 경우 (조망권을 가진 세대가 있는 경우)
				if (a1 >= 1 && a2 >= 1 && a3 >= 1 && a4 >= 1) {
// Math.min() 을 사용하여 가장 차이가 작은 수 추출 ( = 조망권을 가진 세대 수)
					int min = Math.min(Math.min(a1, a2), Math.min(a3, a4));
					cnt += min;
				}
			}

			System.out.println("#" + test_case + " " + cnt);

		}
	}
}

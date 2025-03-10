package Algorithm_Study.daily.JSH;

import java.util.Scanner;

public class D20250309 {
	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 10; test_case++) {
			int tc = sc.nextInt();

			int[][] arr = new int[100][100];
			// 2의 위치 시작점
			int idx = 0;
			// 배열 입력 받기
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
					// 만약 입력받은 숫자가 2일 경우
					if (arr[99][j] == 2) {
						// 위치 저장
						idx = j;
					}
				}
			}

			int r = 99;
			while (true) {
				// 현재 2의 위치에서 좌측에 1이 있을 경우
				if (idx > 0 && arr[r][idx - 1] == 1) {
					// 1이 있는 위치까지 idx 계속 이동
					while (idx > 0 && arr[r][idx - 1] == 1) {
						idx--;
					}
					// 현재 2의 위치에서 우측에 1이 있을 경우
				} else if (idx < 99 && arr[r][idx + 1] == 1) {
					// 1이 있는 위치까지 idx 계속 이동
					while (idx < 99 && arr[r][idx + 1] == 1) {
						idx++;
					}
				}
				//없으면 위로 올라간다.
				r--;
				//0에 도착하면 종료
				if (r == 0) {
					break;
				}
			}

			System.out.println("#" + test_case + " " + idx);

		} // test_case
	} // main
}

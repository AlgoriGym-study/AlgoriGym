package Algorithm_Study.daily.LYW;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

public class D2025_04_28_SWEA_flatten {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for (int test_case = 1; test_case <= T; test_case++) {

			int dump = sc.nextInt();
			int N = 100;
			int[] arr = new int[N];
// 입력값 배열로 저장
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

// 배열의 min, max값 구하기
			int min = 101;
			int max = 0;
			int minIdx = 0;
			int maxIdx = 0;

			for (int i = 1; i <= dump; i++) {
// dump 횟수를 다 채우지 않고 평탄화가 완료된 경우 바로 반환
				if (max - min == 0 || max - min == 1) {
					break;
				}
// min, max값과 해당 인덱스를 저장
				for (int j = 0; j < N; j++) {
					if (arr[j] > max) {
						max = arr[j];
						maxIdx = j;
					}
					if (arr[j] < min) {
						min = arr[j];
						minIdx = j;
					}
				}

// dump 한번 돌때마다 최대값에서 -1되고, 최소값에서 +1 된다. 
				arr[maxIdx] -= 1;
				arr[minIdx] += 1;
// 다시 초기화해주지 않으면 min, max값이 계속 고정됨
				min = 101;
				max = 0;

			}

// 최종 min, max값 추출 후 결과 출력
			for (int i = 0; i < N; i++) {
				if (arr[i] > max) {
					max = arr[i];
				}
				if (arr[i] < min) {
					min = arr[i];
				}
			}

			System.out.println("#" + test_case + " " + (max - min));

		}
	}
}
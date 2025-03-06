package Algorithm_Study.common.C20250307;

import java.util.Arrays;
import java.util.Scanner;

public class LYW {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] arr = new int[N]; // 야구선수 배열
			
			// 배열에 야구선수 실력값 넣기
			for(int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			
			// 오름차순 정렬
			Arrays.sort(arr);
			
			/*
			 *  선택된 선수들의 최소 실력과 최대 실력의 차이가 k 이하가 되어야 한다
			 *  -> arr[j]값이 arr[i]+k 보다 작거나 같으면 같은 팀이 될 수 있다.
			 *  따라서 최소값부터 완전탐색하면서 가장 인원수가 많은 경우를 구한다. 
			 */

			int answer = 0; // 팀 인원수 최대값
			
			for(int i = 0; i < N; i++) {
				int cnt = 0; // answer과 비교할 팀 인원수
				for(int j = i; j < N; j++) {
					if(arr[j] <= (arr[i] + K)) { // 실력의 차이가 k 이하인 경우 -> cnt++
						cnt++;
					}
					else break; // 실력의 차이가 k 초과된 경우 -> break
				}
				// answer 과 cnt 비교하여 최대값 최신화
				answer = Math.max(answer, cnt);
			}
			
			System.out.println("#" + tc + " " + answer);
			
		}// tc
	}
}

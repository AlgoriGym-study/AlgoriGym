package Algorithm_Study.common.C20250424;

import java.util.Scanner;

//SWEA 최대상금
public class PJE {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			String numstr= sc.next(); // 숫자판 정보
			int len = numstr.length(); // 숫자판 길이
			int [] nums = new int [len]; // 숫자판 배열
			for (int i = 0; i < len; i++) {
				nums[i] = numstr.charAt(i)-'0';
			}
			int N = sc.nextInt(); // 교환 횟수
			boolean isChanged = false;
			// 앞쪽부터 숫자배열 뒷쪽과 비교하면서 더 큰 숫자와 교환
			i : for (int i = 0; i < len; i++) {
				for (int j = len-1; j > i ; j--) {
					if (N <= 0) break i; //교환횟수가 없으면 교환 끝내버리기
					
					// 한바퀴 돌면서 숫자가 더 크면 교환하고 교환 했다면 횟수 -1하기
					if(nums[i] < nums[j]) { 
						int tmp = nums[j];
						nums[j] = nums[i];
						nums[i] = tmp;
						isChanged = true;
					// 숫자가 같거나 작으면 넘기기 >> 예외처리 필요
					}else { 
						continue;
					}
				}
				if(isChanged) {
					N --;
					isChanged = false;
				}
			}
			
			// 교환 횟수 없으면 그대로 리턴
			// 정렬을 다 했는데 아직 교환 횟수 남아있으면? 
			// 횟수가 짝수번 남았을 경우 : 다시 복귀가 가능하므로 그냥 리턴해도 됨 
			// 횟수가 홀수번 남았을 경우 : 짝수번동안 원래 숫자배열로 복구한다고 가정하고 맨 뒤 한번만 바꾸면됨
			if(N != 0 && N%2 ==1) {
				int tmp = nums[len-2];
				nums[len-2]	= nums[len-1];
				nums[len-1] = tmp;
			}
			System.out.print("#"+tc+" ");
			for (int i = 0; i < len; i++) {
				System.out.print(nums[i]);
			}
			System.out.println();
		}
	}
}

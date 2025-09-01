package Algorithm_Study.common.C202508.C20250806;

import java.util.Scanner;

public class LYW0038 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String number = sc.next();
		int k = sc.nextInt();
		
		solution(number, k);
		
		
	}
	
	// number = 1924 , k = 2
	public static String solution(String number, int k) {
		int n = number.length();
		int targetLen = n - k;     // 최종 결과 길이
		char[] digits = number.toCharArray();
		char[] stack = new char[n];// 스택처럼 사용할 배열
		int top = -1;              // 스택 top 인덱스(-1이면 비어있음)

		for (int i = 0; i < n; i++) {
		    char cur = digits[i];

		    while (k > 0 && top >= 0 && stack[top] < cur) {
		        top--;
		        k--;
		    }
		    stack[++top] = cur; // 현재 숫자 push
		}

		// 앞에서 targetLen개만 문자열로 만들기
		return new String(stack, 0, targetLen);

	}
}





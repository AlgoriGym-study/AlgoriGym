package Algorithm_Study.daily.PJE;

import java.util.Scanner;

//백준 팩토리얼2
public class D20250309 {
	static long res = 1;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		long answer = factorial2(T);
		System.out.println(answer);
	}

	static int factorial(int num) {

		int res = 1;
		for (int i = num; i >= 1; i--) {
			res *= i;
		}

		return res;
	}

	static long factorial2(int num) {
		// 종료
		if (num <= 1)
			return res;
		// 재귀
		res = res * num;
		num--;
		return factorial2(num);

	}

	static long factorial3(int num) {
		if (num <= 1)
			return 1;
		return num * factorial3(num - 1);

	}
}

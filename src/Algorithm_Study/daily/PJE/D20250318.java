package Algorithm_Study.daily.PJE;

import java.util.Scanner;
import java.util.Stack;
//1232. [S/W 문제해결 기본] 9일차 - 사칙연산
public class D20250318 {
	static String[] tree;
	static int[] left;
	static int[] right;
	static double res;
	static Stack<Double> stack;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int N = Integer.parseInt(sc.nextLine());

			tree = new String[N + 1];
			left = new int[N + 1];
			right = new int[N + 1];
			stack = new Stack<Double>();
			res = 0.0;

			for (int i = 0; i < N; i++) {
				String[] str = sc.nextLine().split(" ");
				int n = Integer.parseInt(str[0]);
				String s = str[1];

				tree[n] = s;
				
				if (2 < str.length) {
					left[n] = Integer.parseInt(str[2]);
				}
				if (3 < str.length) {
					right[n] = Integer.parseInt(str[3]);
				}

			}

			System.out.print("#" + tc + " ");
			postOrder(1);
			System.out.println((int)res);

		}
	}

	static void postOrder(int root) {

		if (left[root] != 0)
			postOrder(left[root]);

		if (right[root] != 0)
			postOrder(right[root]);
		
		if (tree[root].equals("+") || tree[root].equals("-") || tree[root].equals("*") || tree[root].equals("/")) {

			double b = stack.pop();
			double a = stack.pop();

			switch (tree[root]) {

			case "+":
				res = a + b;
				break;
			case "-":
				res = a - b;
				break;
			case "*":
				res = a * b;
				break;
			case "/":
				res = a / b;
				break;

			default:
				break;
			}
			stack.push(res);
		} else {
			stack.push(Double.parseDouble((tree[root])));
		}

	}
}

package Algorithm_Study.daily.LYW;

import java.io.File;
import java.util.Arrays;
import java.util.Scanner;


class D2025_03_17_SWEA_중위순회{
	public static char[] tree ;
	public static int[] leftChild;
	public static int[] rightChild;
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T = 10;

		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = Integer.parseInt(sc.nextLine());
			
			tree = new char[N + 1];
			leftChild = new int[N+1];
			rightChild = new int[N+1];
			
			for(int i = 0; i < N; i++) {
				String[] input = sc.nextLine().split(" ");
				int num = Integer.parseInt(input[0]);
				char data = input[1].charAt(0);
				tree[num] = data;
				
				if(2 < input.length) {
					int left = Integer.parseInt(input[2]);
					leftChild[num] = left;
				}
				
				if(3 < input.length) {
					int right = Integer.parseInt(input[3]);
					rightChild[num] = right;
				}
				
			}
			
			System.out.print("#" + test_case + " ");
			inorder(1);
			System.out.println();
			
		}
	}
	private static void inorder(int root) {
		// 왼쪽 자식 번호가 있어야만 왼쪽 탐색
		if(leftChild[root] != 0) {
			inorder(leftChild[root]);
		}
		
		System.out.print(tree[root]);
		
		// 오른쪽 자식 번호가 있어야만 오른쪽 탐색
		if(rightChild[root] != 0) {
			inorder(rightChild[root]);
		}
	}
}
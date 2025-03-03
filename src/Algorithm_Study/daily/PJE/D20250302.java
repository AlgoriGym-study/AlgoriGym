package Algorithm_Study.daily.PJE;

import java.util.Scanner;

//Swea 1209. Sum
public class D20250302 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			
			int tc = sc.nextInt();
			int [][] board = new int [100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
				 board[i][j]= sc.nextInt();
				}
			}
			
			int rowSum = 0;
			int maxRowSum = Integer.MIN_VALUE; 
			int colSum = 0;
			int maxColSum = Integer.MIN_VALUE; 

			for (int i = 0; i < 100; i++) {
				rowSum = 0;
				colSum = 0;
				for (int j = 0; j < 100; j++) {
					rowSum += board[i][j];
					colSum += board[j][i];
				}
				if(maxRowSum < rowSum) maxRowSum = rowSum;
				if(maxColSum < colSum) maxColSum = colSum;
			}

					
			int downRightdia = 0; 
			int downleftdia = 0; 
			
			for (int i = 0; i < 100; i++) {
				downleftdia += board[i][i];
				downRightdia += board[i][99-i];
			}
			
			int answer = Integer.max(Integer.max(downRightdia,downleftdia), Integer.max(maxRowSum,maxColSum));
			System.out.println("#"+tc+" "+answer);

		}
	}
}

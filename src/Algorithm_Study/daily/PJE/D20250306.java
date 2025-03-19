package Algorithm_Study.daily.PJE;


import java.util.Scanner;
//백준 부녀회장이 될테야 
//메모제이션 활용
public class D20250306 {
	static int[][] memo;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int k = sc.nextInt();
			int n = sc.nextInt();
			
			memo = new int[k+1][n+1];
			
			int answer = number(k,n);//k층 n호
			System.out.println(answer);
		}
	}
	
	// a층 b호에 사는 사람들의 수 구하기
	static int number(int a, int b) {
		
		if(a ==0)
			return b;
		if(memo[a][b]!=0)
			return memo[a][b];
		
		int sum = 0;
		for (int i = 1; i <= b; i++) {
			sum+=number(a-1,i);
		}
		return memo[a][b]= sum;
	}
}

package Algorithm_Study.daily.LYW;
import java.util.Scanner;
import java.util.Arrays;
import java.io.FileInputStream;

class D2025_03_18_SWEA_퍼펙트셔플
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
		
			int N = sc.nextInt();
			
			String[] leftArr; // 먼저 놓는쪽 카드덱
			if(N % 2 == 0) {
				leftArr = new String[N/2];
			} else {
				leftArr = new String[N-(N/2)];
			}
			String[] rightArr = new String[N/2]; // 나중에 놓는쪽 카드덱			
			
			// N이 짝수일때는 반반 나눠서 입력값을 배열에 넣고
			if(N % 2 == 0) {
				for(int i = 0; i < N/2; i++) {
					leftArr[i] = sc.next();
					}		
				for(int i = 0; i < N/2; i++) {
					rightArr[i] = sc.next();
					}
			}
			// N이 홀수일때는 왼쪽에 한장이 더 들어간다.
			else {
				for(int i = 0; i <= N/2; i++) {
					leftArr[i] = sc.next();
					}		
				for(int i = 0; i < N/2; i++) {
					rightArr[i] = sc.next();
					}
			}
			
			// 답을 담을 answer배열을 만들고 홀수에는 left배열의 값을, 짝수에는 right배열의 값을 넣는다
			String[] answerArr = new String[N];
			int a = 0;
			int b = 0;
			for(int i = 0; i < N; i++) {
				if(i % 2 == 0) {
					answerArr[i] = leftArr[a];
					a++;
				}else {
					answerArr[i] = rightArr[b];
					b++;
				}
			}
			
			// 정답 출력
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < N; i++) {
				System.out.print(answerArr[i] + " ");
			}
			System.out.println();

		}
	}
}
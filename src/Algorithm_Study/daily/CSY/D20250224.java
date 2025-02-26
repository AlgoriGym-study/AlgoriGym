package Algorithm_Study.daily.CSY;

import java.util.Scanner;

public class D20250224 {
	public static void main(String[] args) throws Exception {
	    solution();
	}

	static void solution(){
		Scanner sc= new Scanner(System.in);

		int T = sc.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			int N = sc.nextInt(); // 전체 개수

			int[] arr = new int[N];

			for(int i=0; i<N;i++) {
				arr[i] = sc.nextInt();
			}

			long sum = 0; // 이익
			long max = 0;
			// 뒤에서부터 for문 돌리면서 전의 값보다 크면 해당 금액 - 전의 값의 가격을 sum에 저장
			// ex) 1, 2, 3이면 첫 순회에서 최대값은 3이 되고, 전의 값 2를 3에서 빼면 sum에 저장되는 값은 1이 된다.
			// 두번째 순회에서도 여전히 최대값은 3이다. 그럼 sum에 더해지는 값은 3-1인 2이다.
			for(int j=N-1;j>=0;j--) {
				if(max < arr[j]) {
					max = arr[j];
				}else{
					sum += max - arr[j];
				}

			}
			System.out.println("#" + tc +" " + sum);
		}

	}
}

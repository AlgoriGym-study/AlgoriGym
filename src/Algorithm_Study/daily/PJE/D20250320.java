package Algorithm_Study.daily.PJE;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class D20250320 {
	static long answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			
			int N = sc.nextInt(); // 몇개의 쌍을 넣을 것인지 
			int A = sc.nextInt(); // 처음 공책에 쓴 자연수 
			//내림
			PriorityQueue<Integer> min = new PriorityQueue<>(Collections.reverseOrder());
			//오름
			PriorityQueue<Integer> max = new PriorityQueue<>();
			
			//가운데로 설정
			int mid = A;
			min.add(mid);
			
			answer = 0L;
			
			for (int i = 0; i < N; i++) {
				//숫자 1,3/2,6/8,9
				int X = sc.nextInt();
				int Y = sc.nextInt();
				// 가운데 숫자를 기준으로 min max 맞춰 힙에 넣기
				// min = 5 3 2 1  max =    6 8 9
				// 1 5 
				if( X < mid ) {
					min.add(X);
				}else {
					max.add(X);
				}
				
				if( Y < mid ) {
					min.add(Y);
				}else {
					max.add(Y);
				}
				/////////////////
				/// 작은 쪽이 숫자가 하나 더 큰 경우에만 중간값을 가진다는 의미이기 때문에 크기 맞춰주기
				if(max.size()+1 < min.size()) {
					max.add(min.poll());
				}
				
				else if(min.size() < max.size()) {
					min.add(max.poll());
				}
				
				
				mid = min.peek();
				answer = (answer + mid )% 20171109;
				
			}
			System.out.println("#"+tc+" "+answer);
		}
	}
}

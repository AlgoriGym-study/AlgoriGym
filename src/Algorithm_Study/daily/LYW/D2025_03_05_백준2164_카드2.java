package Algorithm_Study.daily.LYW;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D2025_03_05_백준2164_카드2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		// 큐에 카드 넣기
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			queue.add(i);
		}
		
		// 제일 위 카드를 poll 하고 , 그 다음 위의 카드를 제일 밑으로 집어 넣는다
		// queue의 size가 1이 될때 까지 반복한다.
		while(true) {
			if(queue.size() > 1) {
				// 제일 위 카드 한장 버리기
				queue.poll();
				if(queue.size() == 1) { // queue의 size가 1일되면 멈춘다.
					break;
				}
				
				// 그다음 카드 poll하고 다시 add하기
				int num = queue.poll();
				queue.add(num);
			}
			else {
				break;
			}
		}
		
		// 반복문이 다 돌았을 때 queue에 남아있는 값이 마지막으로 남게 되는 카드가 된다.
		int answer = queue.poll();
		
		System.out.println(answer);
		
		
	} // main
}

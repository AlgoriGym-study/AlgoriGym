package Algorithm_Study.daily.LYW;
import java.io.File;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class D2025_03_03_SWEA_암호생성기 {
	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(new File("input.txt"));
		
		for(int tc = 1; tc <= 10; tc++) {
			int tcNum = sc.nextInt();
			Queue<Integer> queue = new LinkedList<>();
			// 큐에 입력값 넣기
			for(int i = 0; i < 8; i++) {
				queue.add(sc.nextInt());
			}
			
			// 한 사이클을 while문을 통해 계속 돌리면서 솟자가 0 이하가 되는 경우 break
		first: while(true) {
				for(int i = 1; i <= 5; i++) {
					int num = queue.poll() - i;
					// num이 0 이하가 되는 순간 암호 완성
					if(num <= 0) {
						num = 0;
						queue.add(num);
						break first;
					}
					queue.add(num);
				}
				
			}
			
			System.out.print("#" + tc + " ");
			int N = queue.size();
			for(int i = 0; i < N; i++){
				System.out.print(queue.remove() + " ");
			}
			System.out.println();
			
		} // tc
	}
}  
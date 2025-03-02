package Algorithm_Study.daily.LYW;
import java.util.Scanner;

public class D2025_02_28_백준1436_영화감독_숌 {
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		
		int N = sc.nextInt();
		
		// N번째로 작은 666이 연속으로 들어가는 수 구하기
		// 665부터 1씩 늘려가면서, 666이 연속으로 들어가는 수가 나오면 cnt++ 하고 N과 cnt를 비교하여 같은 값일때까지 반복한다.
		int movieNum = 665;
		String movieStr = "666";
		int cnt = 0;
		
		while(true) {			
			movieNum++;
			String str = String.valueOf(movieNum);
			
			// 증가시킨 movieNum이 666이 연속으로 들어가는 수인지 판단
			if(str.contains(movieStr)) {
				cnt++;
			}
			// 구한 수가 N번재로 작은 수인 경우 -> 정답
			if(cnt == N) {
				break;
			}			
		}
		
		System.out.println(movieNum);
		
	}
}

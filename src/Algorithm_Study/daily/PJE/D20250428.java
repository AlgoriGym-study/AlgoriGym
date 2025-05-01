package Algorithm_Study.daily.PJE;
import java.util.Arrays;
import java.util.Scanner;

// SWEA Flatten
public class D20250428 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int dump = sc.nextInt();
			int [] box = new int [100]; 
			int maxHeight = -1;
			for (int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
				if( maxHeight < box[i])
					maxHeight = box[i];
			}

      // 제일 높은 곳의 박스를 제일 낮은 곳으로 옮기면 덤프 1
			// 덤프 = 0 혹은 최고-최저 < 1 이 되면 멈추고
			// 최고점 - 최저점의 차이를 반환 해야함
			
			// 가장 높은곳 -1 낮은 곳 +1 로 덤프수만큼 반복하기 
			for (int i = 0; i <dump ; i++) {
				Arrays.sort(box);
				for (int j = 99; j >= 0; j--) {
					if(box[j]>0) {
						box[j]--;
						break;
					}
				}
				for (int j = 0; j < 100; j++) {
					if(box[j]>0) {
						box[j]++;
						break;
					}
				}
				
			}
			Arrays.sort(box);
			// 종료 조건에 도달하면 답 반환하기 
			int answer = box[99]-box[0];
			System.out.println("#"+tc+" "+ answer);
		}
	}
}

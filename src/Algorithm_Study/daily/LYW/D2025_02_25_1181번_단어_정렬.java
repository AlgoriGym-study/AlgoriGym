package Algorithm_Study.daily.LYW;
import java.util.Arrays;
import java.util.Scanner;

public class D2025_02_25_1181번_단어_정렬 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		String[] arr = new String[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		
		for(int j = 0; j < N-1; j++) {
			for(int i = 0; i < N-1; i++) {
				// 중복된 단어는 하나만 남기고 제거한다
				// 방법이 떠오르지 않아 중복되면 하나를 0으로 바꾼뒤 출력할때 0을 빼고 출력하는 방법 사용
				if(arr[i].equals(arr[i+1])) {
					arr[i+1] = "0";
				}
				// 길이가 가장 큰 단어를 제일 뒤로 보낸다
				else if(arr[i].length() > arr[i+1].length()) {
					String str = arr[i];
					arr[i] = arr[i+1];
					arr[i+1] = str;
				}
				// 길이가 같은 경우 사전 순서대로 바꾼다
				else if (arr[i].length() == arr[i+1].length()) {
					// 비교할 두 문자열을 인덱스 순서대로 문자로 받아 순서 비교
					for(int k = 0; k < arr[i].length(); k++) {
						char ch1 = arr[i].charAt(k);
						char ch2 = arr[i+1].charAt(k);
						// 앞의 문자열이 사전 순서상 뒤에 있는 경우 swap
						if(ch1 > ch2) {
							String str = arr[i];
							arr[i] = arr[i+1];
							arr[i+1] = str;
							break;
						}
					}
				}
			}			
		}
		
		// 중복된 값을 "0"으로 바꿨기 때문에 빼고 출력한다.
		for(int i = 0; i < N; i++) {
			if(arr[i] != "0")
			System.out.println(arr[i]);
		}
		
	}	
}
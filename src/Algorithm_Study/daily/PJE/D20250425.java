package Algorithm_Study.daily.PJE;
import java.util.Scanner;

// SWEA 중간값 찾기
public class D20250425
{
	public static void main(String args[])
	{

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 점수 개수 
		int[] arr = new int[N]; // 점수 배열 
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		} //입력
		
//		카운팅 정렬로 중간값 가져오기
		
//		1. 가장 큰값 찾기
		int max = 0;
    	for(int i = 0; i < N; i++){
        	if(max < arr[i]) max = arr[i];
        }
//		2. 카운팅 배열 만들어서 중복값 저장
		int [] count = new int [max+1];
        for(int i = 0; i < N; i ++){
        	count[arr[i]]++;
        }
//		3. 누적합 구하기
		for(int i = 1; i < max; i++){
        	 count[i] += count[i-1];
        }
		
//		4. 새로운 배열 만들어서 값 넣기. 마지막 값부터 확인하기 때문에 원본의 순서가 바뀌지 않아 안정정렬. 		
		int [] ans = new int [N];
        for(int i = N-1; i >= 0 ; i --){
          ans[count[arr[i]]-1] = arr[i];
          count[arr[i]] --;
        }
//		답 출력
		System.out.println(ans[arr.length/2]);
	
	}
}

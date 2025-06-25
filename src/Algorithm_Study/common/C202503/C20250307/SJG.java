package Algorithm_Study.common.C202503.C20250307;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SJG {
	public static void main(String[] args) throws Exception {
		// 입출력 및 테스트케이스
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1; tc <= T; tc++) {
			// 최소 한명의 선수는 포함될 수 있으므로 변수 max를 선언 후 1로 초기화
			int max = 1;
			// 야구선수 인원 N 및 최대 실력차이지수인 K입력받음
			String[] inputNK = br.readLine().split(" ");
			int N = Integer.parseInt(inputNK[0]);
			int K = Integer.parseInt(inputNK[1]);
			
			// N명의 야구선수들의 실력을 입력받아 정수형 배열 arr에 할당.
			String[] input = br.readLine().split(" ");
			int[] arr = new int[N];
			for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(input[i]);
			
			// i가 N-1일 경우 max값이 초기화 값인 1과 동일해지므로 제외한 후 순회
			for(int i = 0; i < N-1; i++) {
				// 최대 N명의 선수까지 동적으로 할당될 수 있으므로 list사용
				List<Integer> list = new ArrayList<>();
				// i번째 선수부터 한명씩 실력차이검증
				for(int j = i; j < N; j++) {
					// list가 비어있을때는 무조건 리스트에 추가
					if(list.isEmpty()) list.add(arr[j]);
					// list의 0번째 인덱스가 가장 실력이 낮은 선수 이므로 해당 선수와의 실력차를 구해 조건에 부합할 경우 리스트에 추가
					else if(arr[j] - list.get(0) <= K) list.add(arr[j]);
					// 조건에 부합하지 않을 시 실력이 더 좋은 선수들은 포함될 수 없으므로 break처리
					else break;
				}
				// list.size가 포함될 수 있는 선수의 수와 같으므로 max와 비교후 더 큰 값을 max에 할당
				max = list.size() > max ? list.size() : max;
			}
			
			sb.append("#").append(tc).append(" ").append(max).append("\n");
		}
		br.close();
		System.out.print(sb);
	}
}

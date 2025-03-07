public class D20250305 {
	public String solution(int n) {
		String answer = "";
		//수박을 받기 위해 배열의 길이가 2인 배열 만듬
		String[] arr = new String[2];
		//[0]에는 '수', [1]에는 '박' 입력
		arr[0] = "수";
		arr[1] = "박";

		//n을 2로 나눌 때 나머지가 0이면 '수', 아니면 '박' 출력
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				answer += arr[0];
			} else {
				answer += arr[1];
			}
		}

		System.out.println(answer);
		return answer;
	}
}

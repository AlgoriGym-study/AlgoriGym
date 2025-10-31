package Algorithm_Study.daily.LYW;

public class D2025_10_29_프로그래머스_택배상자꺼내기 {
	class Solution {
	    public int solution(int n, int w, int num) {
	        // num이 있는 층(level, 1부터)과 그 층에서의 위치(pos, 1~w)
	        int level = (num - 1) / w + 1;
	        int pos = (num - 1) % w + 1;

	        int count = 0;

	        while (true) {
	            // 해당 층에서의 실제 상자 번호 계산
	            // 지그재그이므로: 홀수층은 좌->우, 짝수층은 우->좌
	            int value;
	            if ((level & 1) == 1) {           // 홀수층
	                value = (level - 1) * w + pos;
	            } else {                           // 짝수층(우->좌)
	                value = (level - 1) * w + (w - pos + 1);
	            }

	            if (value > n) break;              // 창고에 존재하지 않으면 종료
	            count++;                           // 해당 층 상자 포함

	            level++;                           // 위층으로 이동
	            // 같은 열을 유지하려면 pos를 뒤집는다 (지그재그 효과)
	            pos = w - (pos - 1);               // == w - pos + 1
	        }

	        return count; // 'num'을 포함해 꺼내야 하는 상자 총 개수
	    }
	}
}

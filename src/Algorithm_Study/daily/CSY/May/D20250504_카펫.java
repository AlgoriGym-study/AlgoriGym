package Algorithm_Study.daily.CSY.May;

public class D20250504_카펫 {
        public int[] solution(int brown, int yellow) {
            int[] answer = new int[2];

            int area = brown + yellow;
            // yellow가 최솟값인 1이라고 가정했을 때, 브라운은 가로세로 3이 최솟값임.
            int start = 3;
            // 가로, 세로가 3부터 시작이기 때문에 넓이는 area/3까지만 검색하면 됨.
            int end = area / 3;

            // 완전 탐색
            for(int w = start ; w <= end; w++){
                for(int h = start; h <= end; h++){
                    // 1. w * h가 area이면서
                    // 가로-2 * 세로 - 2가 yellow와 같으면서
                    // w길이가 h보다 큰 경우
                    if((w * h == area) && ((w-2)*(h-2) == yellow) && w >= h) {
                        answer[0] = w;
                        answer[1] = h;
                        return answer;
                    }
                }
            }
            return answer;
        }
}

package Algorithm_Study.daily.PJE.D202606;
public class D20260609 {
    public int[] solution(int n, long left, long right) {
        // answer의 크기 정하기 
        int len = (int)(right - left +1);
        int [] answer = new int [len];
        // 1차원 배열의 인덱스 기반으로 요소 구하기
        int idx = 0;
        for(long i = left; i <= right; i++){
            long row = i/n+1;
            long col = i%n+1;
            answer[idx++] = (int)Math.max(row,col);
            // System.out.println(row+" "+col);
        }
        return answer;
    }
}

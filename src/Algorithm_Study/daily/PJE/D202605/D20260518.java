package Algorithm_Study.daily.PJE.D202605;
public class D20260518 {
    public int solution(int n) {
        int answer = 0;
        // 포문으로 1부터 더하기 시작, n과 같아질때 멈추기 <- 카운트
        // 더하다가 15보다 커지면 멈추기
        
        for(int j = 1; j <= n; j++){
            int num = 0; // 초기화
            for(int i = j; i <= n; i++){
                num += i;
                if(num > n){
                    break;
                }else if(num == n){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}

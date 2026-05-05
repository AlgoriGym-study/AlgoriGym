package Algorithm_Study.daily.PJE.D202605;
public class D20260503 {
    public int solution(int left, int right) {
        int answer = 0;
        //약수 개수가 짝수면 더하고 홀수면 빼라
        for(int i = left; i <= right; i++){
            int n = cntNums(i); //약수 개수
            if(n%2==0){
                answer+=i;
            }else{
                answer-=i;
            }
            
        }
        return answer;
    }
    public int cntNums(int num){
        int cnt = 0;
        for(int i = 1; i*i <= num; i++){
            if(i*i == num){
                cnt++;
            }else if(num%i==0){
                cnt+=2;
                
            }
            
        }
        return cnt;
    }
}

package Algorithm_Study.daily.PJE.D202512;

// 프로그래머스 조건문자열
public class D20251210 {
    public int solution(String ineq, String eq, int n, int m) {
        int answer = 0;
        if(ineq.equals("<") && n <= m){
            answer = 1;
        }else if(ineq.equals(">") && n>=m){
            answer = 1;
        }
        return answer;
    }
}

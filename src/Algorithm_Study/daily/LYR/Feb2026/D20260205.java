package Algorithm_Study.daily.LYR.Feb2026;

public class D20260205 {
    public String solution(int n) {
        String answer = "";
        for(int i=1;i<=n;i++){
            if(i % 2 == 1)
                answer += "수";
            else
                answer += "박";
        }
        return answer;
    }

    public static int solution(int left, int right) {
        int answer = 0;
        for(int i=left;i<=right;i++){
            int count = 0;
            for(int j=1;j<=i;j++){
                if(i % j == 0)
                    count++;
            }
            if(count % 2 == 1)
                answer -= i;
            else
                answer += i;
        }
        return answer;
    }
}

package Algorithm_Study.daily.LYR.Jun2026;

public class D20260623 {
    public int[] solution(int n) {
        int size = 0;
        if(n % 2 == 1)
            size = n/2 + 1;
        else
            size = n/2;
        int[] answer = new int[size];
        int idx = 0;
        for(int i=1;i<=n;i++){
            if(i % 2 == 1)
                answer[idx++] = i;
        }
        return answer;
    }

    public int solution(int[] sides) {
        int answer = 0;
        int max = 0;
        int idx = 0;
        for(int i=0;i<3;i++){
            if(max < sides[i]){
                max = sides[i];
                idx = i;
            }
        }

        switch(idx){
            case 0:
                if(sides[1] + sides[2] <= max)
                    return 2;
                else
                    return 1;
            case 1:
                if(sides[0] + sides[2] <= max)
                    return 2;
                else
                    return 1;
            case 2:
                if(sides[0] + sides[1] <= max)
                    return 2;
                else
                    return 1;
            default:
                return 0;
        }
    }
}

package Algorithm_Study.daily.LYR.Jan2026;

public class D20260108 {
    public boolean solution(int x) {
        String[] numList = String.valueOf(x).split("");
        int sum = 0;
        for(String num : numList){
            sum += Integer.parseInt(num);
        }
        if(x % sum == 0)
            return true;
        else
            return false;
    }
}

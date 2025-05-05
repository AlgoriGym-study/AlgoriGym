package Algorithm_Study.common.C20250506;


public class CSY {

    public static void main(String[] args) {
        int[] diffs = {1, 99999, 100000, 99995};
        int[] times = {9999, 9001, 9999, 9001};
        int a = solution(diffs, times, 3456789012L);
        System.out.println(a);

    }

    public static int answer(int[] diffs, int[] times, long limit) {
        int answer = -1;
        int left = 1;
        int right = 100000;

        while(left <= right) {
            int mid = (left + right) / 2;
            long time = solution(diffs, times, mid);
            if(mid <= time) {
                answer = mid;
                right = mid + 1;
            }else {
                left = mid + 1;
            }
        }

        return answer;
    }

    public static int solution(int[] diffs, int[] times, long limit) {

        //숙련도의 최솟값을 구해야 함.
        int level = 1;
        while(true){
            long time = times[0];
            f: for(int i = 1; i < diffs.length; i++){
                if(diffs[i] <= level){
                    time += times[i];
                }else{
                    long cnt = diffs[i] - level;
                    time += (times[i-1] + times[i]) * cnt + times[i];
                }

                if(time > limit) break f;
            }
            if(time <= limit) return level;
            level++;
        }

    }


}


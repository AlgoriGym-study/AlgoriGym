package Algorithm_Study.common.C20250506;

public class SJG {
	public int solution(int[] diffs, int[] times, long limit) {
        int maxDiff = 0;
        // maxDiff값을 diffs배열의 최대값으로 갱신
        for(int d : diffs) maxDiff = maxDiff > d ? maxDiff : d;
        
        int left = 1;
        int right = maxDiff;
        while(left < right) {
            int mid = (left + right) / 2;
            long total = 0;
            int prev = 0;
            
            for(int i = 0; i < diffs.length; i++) {
                int curr = times[i];
                if(mid >= diffs[i]) total += curr;
                else {
                    int chance =  diffs[i] - mid;
                    total += chance * (prev + curr) + curr;
                    if(total > limit) break;
                }
                prev = curr;
            }
            
            if(total <= limit) right = mid;
            else left = mid + 1;
        }
        
        return left;
    }
}

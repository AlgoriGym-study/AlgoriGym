package Algorithm_Study.common.C20250506;

class PJE {
    public int solution(int[] diffs, int[] times, long limit) {
    int left = 1;
    int right = 1_000_000_000; // 숙련도의 upper bound 추정
    int answer = 0;

    while (left <= right) {
        int mid = (left + right) / 2;
        long total = 0;

        for (int i = 0; i < diffs.length; i++) {
            if (diffs[i] <= mid) {
                total += times[i];
            } else {
                long penalty = (i == 0 ? 0 : times[i - 1]) + times[i];
                total += penalty * (diffs[i] - mid) + times[i];
            }
            if (total > limit) break; // 시간 초과시 바로 중단
        }

        if (total <= limit) {
            answer = mid;
            right = mid - 1; // 더 작은 숙련도로도 가능할지 확인
        } else {
            left = mid + 1;
        }
    }

    return answer;
}

// 시간 초과 버전
public int solution2(int[] diffs, int[] times, long limit) {
    int answer = 0;
    
    // result = 숙련도
    for(int result = 1; result < limit; result++){
        long total = 0L; // 총 걸린 시간. limit을 넘기면 안됨
        for(int i = 0; i < diffs.length; i++){
            
            // 난이도 <= 숙련도 
            if(diffs[i] <= result){
                total += times[i];
            // 난이도 > 숙련도 
            }else {
                // (전에 걸린 시간 + 현재 시간 ) *  (난이도 - 숙련도 = 틀리는 시간) + 현재 시간(= 다시 푼 시간) 
                total += (times[i-1] + times[i]) *  (diffs[i]- result) + times[i];

            }
            
        }
        if(total <= limit) {
            answer = result;
            break;
        }
    }
    return answer;
}
}
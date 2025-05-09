package Algorithm_Study.daily.CSY.May;

public class D20250508_점프와_순간이동 {
    public int solution(int n) {
        int ans = 0;
        // 순간이동은 지금까지 온 거리 * 2 : 건전지 없음
        // K까지 점프 : 건전지 K

        // n의 약수 중 최솟값까지 점프 혹은 점프 + 순간이동으로
        // 1J -> 2 -> 1J(3) -> 6

        // 역순으로 계산
        while(n > 0){
            if(n % 2 == 0){
                // 나머지가 없으면 순간이동을 한 것
                n /= 2;
            }else{
                n--; // 그게 아니면 한 칸 점프
                ans++;
            }
        }

        return ans;
    }
}

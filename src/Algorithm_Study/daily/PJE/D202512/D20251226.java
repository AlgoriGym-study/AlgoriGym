package Algorithm_Study.daily.PJE.D202512;
public class D20251226 {
    public int[] twoSum(int[] nums, int target) {
        // 이중 반복문으로 모든 쌍을 확인
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // 두 수의 합이 target과 일치하는지 확인
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        return new int[] {};
    }
}

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] result = new int[2 * n]; 
        int result_idx = 0;
        int A_idx = 0; 
        int B_idx = n; 
        for (int i = 0; i < n; i++) {
            result[result_idx++] = nums[A_idx++]; 
            result[result_idx++] = nums[B_idx++]; 
        }
        return result;
    }
}

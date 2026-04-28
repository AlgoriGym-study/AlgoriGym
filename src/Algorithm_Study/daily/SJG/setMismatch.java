package Algorithm_Study.daily.SJG;

public class setMismatch {
    public int[] findErrorNums(int[] nums) {
        long n = nums.length; 
        long expectedSum = n * (n + 1) / 2;
        long expectedSumSq = n * (n + 1) * (2 * n + 1) / 6;

        long actualSum = 0;
        long actualSumSq = 0;
        
        for (int num : nums) {
            actualSum += num;
            actualSumSq += (long)num * num;
        }
        long diff1 = actualSum - expectedSum;
        long diff2 = actualSumSq - expectedSumSq;
        long sum_AB = diff2 / diff1;

        long duplicate = (diff1 + sum_AB) / 2;
        long missing = sum_AB - duplicate;

        return new int[]{(int)duplicate, (int)missing};
    }
}

package Algorithm_Study.daily.SJG;

public class concatenationOfArray {
    public int[] getConcatenation(int[] nums) {
        int[] n = new int[nums.length * 2];
        int idx = 0;
        for(int i = 0; i < 2; i++) {
            for(int num : nums) n[idx++] = num;
        }
        return n;
    }
}

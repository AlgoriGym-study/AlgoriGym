package D202512;

class Solution {
    public int solution(int[] numbers) {
        int[] dat = new int[10];
        for (int i = 0; i < numbers.length; i++) {
            dat[numbers[i]]++;
        }
        
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            if (dat[i] == 0) sum += i;
        }
        return sum;
    }
}

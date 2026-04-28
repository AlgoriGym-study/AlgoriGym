package Algorithm_Study.daily.SJG;

public class maxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] arr) {
        int count = 0;
        int n = arr.length;
        int max = 0;
        for (int i =0; i<n; i++){
            if(arr[i]==1){
                count++;
            }
            else{
                max = Math.max(max, count);
                count=0;
            }
        }
        return Math.max(max, count);
    }
}

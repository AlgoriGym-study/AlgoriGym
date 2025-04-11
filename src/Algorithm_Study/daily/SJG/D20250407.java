package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250407 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputNM = br.readLine().split(" ");
        int N = Integer.parseInt(inputNM[0]);
        int M = Integer.parseInt(inputNM[1]);
        int maxHeight = 0;
        
        String[] input = br.readLine().split(" ");
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(input[i]);
            if(arr[i] > maxHeight) maxHeight = arr[i];
        }
        br.close();
        long result = binarySearch(arr, M, maxHeight);
        System.out.print(result);
    }
    
    private static long binarySearch(int[] arr, long M, int maxHeight) {
        long low = 0;
        long high = maxHeight;
        long result = 0;
        
        while(low <= high) {
            long mid = low + (high - low) / 2;
            
            if(check(mid, arr, M)) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    
    private static boolean check(long high, int[] arr, long M) {
        long total = 0;
        for(int treeHeight : arr) {
            if(treeHeight > high) total += treeHeight - high;
        }
        return total >= M;
    }
}

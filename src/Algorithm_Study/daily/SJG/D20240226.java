package Algorithm_Study.daily.SJG;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class D20240226 {
	public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // A입력
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        String[] inputA = br.readLine().split(" ");
        for(int i = 0; i < N; i++) A[i] = Integer.parseInt(inputA[i]);
        Arrays.sort(A);
        int minVal = A[0];
        int[] count = new int[A[N-1] - minVal + 1];
        for(int i = 0; i < N; i++) count[A[i] - minVal]++;
        
        // B 입력
        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        String[] inputB = br.readLine().split(" ");
        for(int i = 0; i < M; i++) B[i] = Integer.parseInt(inputB[i]);
        br.close();
        
        for(int i = 0; i < M; i++) {
            if(B[i] >= A[0] && B[i] <= A[N-1]) {
                int check = binarySearch(0, N-1, B[i], A);
                if(check == 1) sb.append(count[B[i] - minVal]);
                else sb.append(0);    
            } else sb.append(0);
            sb.append(" ");
        }
        
        System.out.print(sb);
    }
    
    public static int binarySearch(int left, int right, int key, int[] arr) {
        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == key) return 1;
            else if(arr[mid] > key) right = mid - 1;
            else left = mid + 1;
        }
        return 0;
    }
}

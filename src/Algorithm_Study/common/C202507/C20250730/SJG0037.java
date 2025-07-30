package Algorithm_Study.common.C202507.C20250730;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SJG0037 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        if(K >= N) {
            System.out.print(0);
            br.close();
            return;
        }
        
        int[] gap = new int[N-1];
        for(int i = 1; i < N; i++) {
            gap[i-1] = arr[i] - arr[i-1];
        }
        Arrays.sort(gap);
        
        int res = arr[N-1] - arr[0];
        for(int i = 0; i < K - 1; i++) {
            res -= gap[gap.length - 1 - i];
        }
        System.out.print(res);
        br.close();
    }
}

package Algorithm_Study.common.C202507.C20250730;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SJG0037_2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        
        int[] sensors = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }
        
        // 센서 좌표 정렬
        Arrays.sort(sensors);
        
        if(K >= N) {
            System.out.println(0);
            return;
        }
        
        // 인접한 센서들 간의 간격 계산
        int[] gaps = new int[N-1];
        for(int i = 0; i < N-1; i++) {
            gaps[i] = sensors[i+1] - sensors[i];
        }
        
        // 간격을 크기 순으로 정렬
        Arrays.sort(gaps);
        
        // 전체 범위에서 가장 큰 (K-1)개의 간격을 제거
        int totalRange = sensors[N-1] - sensors[0];
        for(int i = 0; i < K-1; i++) {
            totalRange -= gaps[gaps.length - 1 - i];
        }
        
        System.out.println(totalRange);
    }
}

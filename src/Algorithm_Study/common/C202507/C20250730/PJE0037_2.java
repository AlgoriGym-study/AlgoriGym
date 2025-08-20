package Algorithm_Study.common.C202507.C20250730;
import java.util.*;

// 백준 센서 복습
public class PJE0037_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 센서 개수
        int K = sc.nextInt(); // 집중국 개수

        int[] sensors = new int[N]; // 센서 위치
        for (int i = 0; i < N; i++) {
            sensors[i] = sc.nextInt();
        }

        Arrays.sort(sensors);
        // 센서간 거리 차이 저장
        Integer[] distances = new Integer[N - 1]; 
        
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 거리 차이 내림차순 정렬 
        Arrays.sort(distances, Collections.reverseOrder());

        int totalLength = 0;
        for (int i = K - 1; i < distances.length; i++) {
            totalLength += distances[i];
        }

        System.out.println(totalLength);
    }
}

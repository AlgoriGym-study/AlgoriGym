package Algorithm_Study.common.C202508.C20250806;
import java.util.*;

// 백준 센서
public class PJE0037 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 센서 개수
        int K = sc.nextInt(); // 집중국 개수

        int[] sensors = new int[N]; // 센서 위치
        for (int i = 0; i < N; i++) {
            sensors[i] = sc.nextInt();
        }

        Arrays.sort(sensors); // 오름차순 정렬

        Integer[] distances = new Integer[N - 1]; // 센서간 거리 차이 저장 리스트
        for (int i = 0; i < N - 1; i++) {
            distances[i] = sensors[i + 1] - sensors[i];
        }

        // 큰 거리부터 자르기 위해 거리 차이 내림차순 정렬 
        Arrays.sort(distances, Collections.reverseOrder());

        // K-1개의 큰 거리들을 잘라서 그룹을 나눌 것이므로,
        // 전체 거리에서 가장 큰 거리 K-1개를 제외한 나머지를 더함
        int totalLength = 0;
        for (int i = K - 1; i < distances.length; i++) {
            totalLength += distances[i];
        }

        // 결과 출력
        System.out.println(totalLength);
    }
}

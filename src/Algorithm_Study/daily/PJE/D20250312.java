package Algorithm_Study.daily.PJE;
import java.io.FileNotFoundException;
import java.util.Scanner;
//swea 숫자를 정렬하자
public class D20250312 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int test_case = 1; test_case <= T; test_case++) {
             
            //데이터 저장
            int num = sc.nextInt();
            int[] data = new int[num];
 
            for (int i = 0; i < data.length; i++) {
                data[i] = sc.nextInt();
            }
             
            //삽입정렬로 오름차순 정렬. 앞에서부터 이미 정렬된 배열과 비교하면서 자신의 위치를 찾음 
            for (int i = 1; i < data.length; i++) {
 
                int j;
                int key = data[i]; //위치를 찾으려는 키데이터
                
                for (j = i - 1; j >= 0 && key < data[j]; j--) { //데이터의 바로 앞쪽 인덱스 ~ 0까지 확인. 
                    data[j + 1] = data[j]; // 위치를 찾으려는 데이터가 앞쪽데이터보다 작으면 키데이터 뒤로 다 밀어줌
                }
                data[j + 1] = key; // 해당 위치에 키데이터 삽입
            }
             
            //StringBuilder에 숫자 저장 후 출력
            StringBuilder sb = new StringBuilder();
            int idx = 0;
            while (idx < data.length) {
                sb.append(data[idx] + " ");
                idx++;
            }
            String answer = sb.toString();
            System.out.printf("#%d %s\n", test_case, answer);
        }
    }
}

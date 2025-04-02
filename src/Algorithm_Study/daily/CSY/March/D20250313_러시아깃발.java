package Algorithm_Study.daily.CSY.March;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D20250313_러시아깃발 {

    static int N; // 행
    static int M; // 열
    static char[][] flag; // 깃발 배열
    static char[] color = {'W', 'B', 'R'};
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String s = "";

        for(int tc = 1; tc <= T; tc++){
            N = sc.nextInt();
            M = sc.nextInt();
            flag = new char[N][M];
            for (int i = 0; i < N; i++){
                flag[i] = sc.next().toCharArray();
            }// input

            min = Integer.MAX_VALUE; // min 초기화
            List<Character> current = new ArrayList<>();
            current.add('W'); // 첫 번째는 무조건 W니까 미리 넣어주기.
            combcomb(0, current); // 중복 조합 : color 3개 중 N-2개를 택한 경우의 수(중복 포함)

            s += "#" + tc + " " + min + "\n";
        }
        System.out.println(s);
    }

    static void combcomb(int start, List<Character> current){
        if(current.size() == N-1){ //
            if(!current.contains('B')){ // B가 최소 하나는 있어야 함. 따라서 B가 없으면 out!
                return;
            }
            current.add('R'); // 마지막 줄에 R추가(마찬가지로 최소 하나는 있어야 하기 때문)
//            System.out.println(current);
             int tmp = check(current);
             min = Math.min(min, tmp); // check 함수로 나온 값 중 최솟값 갱신
            current.remove(current.size()-1); // 다시 원래대로 돌려줘야 하기 때문에(사이즈 맞추기 위해) remove
            return;
        }

        // 재귀
        for(int i = start; i < color.length; i++){ // color 수 만큼 돌려주기
            current.add(color[i]);
            combcomb(i, current);
            current.remove(current.size()-1); // 원래대로 돌려주기
        }
    }

    // 해당 행에서 각 행에 맞는 색깔이 아니면 count해주는 함수
    static int check(List<Character> current){
        int count = 0;
        for(int i = 0; i < N; i++){ // 행은 총 N개이기 때문에 N개만 탐색
            if(current.get(i) == 'W'){ // 만약 해당 줄이 W이면, W가 아닌 것들 count++, 나머지도 마찬가지
                for(int j : flag[i]){
                    if(j != 'W') count++;
                }
            } else if (current.get(i) == 'B') {
                for(int j : flag[i]){
                    if(j != 'B') count++;
                }
            }else{
                for(int j : flag[i]){
                    if(j != 'R') count++;
                }
            }
        }
        return count;
    }
}

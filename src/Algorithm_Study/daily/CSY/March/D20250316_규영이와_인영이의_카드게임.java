package Algorithm_Study.daily.CSY.March;

import java.util.Scanner;

public class D20250316_규영이와_인영이의_카드게임 {
    static int[] arr1; // 규영이 카드
    static int[] arr2; // 인영이 카드
    static int[] result; // 각 경우의 수
    static boolean[] selected; // 해당 원소가 들어가있는지 아닌지 판별
    static int winCnt;
    static int loseCnt;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        String s ="";
        for(int tc = 1; tc <= T; tc++){

            // 변수 초기화
            arr1 = new int[9];
            arr2 = new int[9];
            result = new int[9];
            selected = new boolean[9];
            winCnt = 0;
            loseCnt = 0;

            // 입력
            for(int i = 0; i < arr1.length; i++){
                arr1[i] = sc.nextInt();
            }

            // 인영이 카드 구하기
            int idx = 0;
            i : for(int i = 1; i < 19; i++){
                for(int a : arr1){
                    if(i == a) continue i;
                }
                arr2[idx++] = i;
            }

            perm(0);

            s += "#" + tc + " " + winCnt + " " + loseCnt + "\n";
        }
        System.out.println(s);
    }

    static void perm(int idx){
        // 기저
        if(idx == arr1.length){
            int total = 0; // 경우의 수마다 총점 초기화
            for(int i = 0; i < arr1.length; i++){
                if(arr1[i] > result[i]){
                    total += arr1[i] + result[i];
                }
            }
            // 1~18까지의 합은 171. 가장 큰 총점은 171.
            if(171 - total > total){
                loseCnt++;
            }else if(171-total < total){ // 총점이 같은 경우는 무승부이기 때문에 else if
                winCnt++;
            }
            return;
        }

        // 재귀
        for(int i = 0; i < arr1.length; i++){
            if(selected[i]) continue;

            selected[i] = true;
            result[idx] = arr2[i];
            perm(idx+1);
            selected[i] = false;
        }
    }
}

package Algorithm_Study.common.C20250314;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CSY {
    static int[] Aarr;
    static int[] Barr;
    static int N;
    static int M;
    static int P;
    static int max;
    static char[] data = {'A', 'B'};

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("src/Algorithm_Study/common/C20250314/input.txt"));
        int T = sc.nextInt();
        String s = "";
        for(int tc = 1; tc <= T; tc++){

            N = sc.nextInt(); // 화분 수
            M = sc.nextInt(); // 비료 효과
            P = sc.nextInt(); // 연속 감소량

            Aarr = new int[N];
            Barr = new int[N];

            for(int i = 0; i < N; i++){
                Aarr[i] = sc.nextInt();
            }

            for(int i = 0; i < N; i++){
                Barr[i] = sc.nextInt();
            }// input

            max = Integer.MIN_VALUE; // 전역변수 초기화
            List<Character> current = new ArrayList<>(); // 중복 조합으로 나온 각 경우의 수

            // 첫 번째로 넣을 수 저장. 둘 중 높은 값을 넣을 건데, 삼항연산자를 이용해서 더 높은 값이 있는 배열을 넣음.
            char first = Math.max(Aarr[0], Barr[0]) == Aarr[0] ? 'A' : 'B';
            current.add(first); // 첫 번째로 넣을 열 저장.
             combcomb(0, current);

            s += "#" + tc + " " + max + "\n";
        }
        System.out.println(s);
    }

    // A와 B로 중복 조합을 통해 N-1개를 만드는 경우의 수를 구하는 함수
    static void combcomb(int start, List<Character> current){
        // 종료
        if(current.size() == N){ // N개 되면 종료!
            int sum = 0;
            for(int i = 0; i < N; i++){
                if(current.get(i) == 'A'){ // A면 A배열에서 M 더한 값을 sum에 더하기
                    if(i - 1 >= 0 && current.get(i-1) == 'A'){ // 이때 A가 연속적인 값이면, P 빼기.
                        sum += Aarr[i] + M - P;
                    }else{
                        sum += Aarr[i] + M;
                    }
                }else{ // 위와 동일한 로직을 B에 적용
                    if(i - 1 >= 0 && current.get(i-1) == 'B'){
                        sum += Barr[i] + M - P;
                    }else{
                        sum += Barr[i] + M;
                    }
                }
            }

            max = Math.max(max, sum);
            System.out.println(current);
            return;
        }

        // 재귀
        for(int i = 0; i < data.length; i++){
            current.add(data[i]); // 경우의 수에 데이터 A, B중 하나 추가
            combcomb(i, current); // 중복조합
//            System.out.println(":::::" + current);
            current.remove(current.size()-1); // 원래대로 돌려주기


        }

    }
}

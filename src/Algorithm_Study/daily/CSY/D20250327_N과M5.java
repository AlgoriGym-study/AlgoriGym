package Algorithm_Study.daily.CSY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class D20250327_N과M5 {


    static int N, M;
    static int[] data;
    static int[] result;
    static boolean[] visited;
    static List<int[]> list;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        data = new int[N];
        result = new int[M];
        visited = new boolean[N];
        list = new ArrayList<int[]>();

        for(int i = 0; i < N; i++) {
            data[i] = sc.nextInt();
        }

        for(int i = 0; i < N; i++) {
            for(int j = i; j < N; j++) {
                if(data[i] > data[j]) {
                    int tmp = data[i];
                    data[i] = data[j];
                    data[j] = tmp;
                }
            }
        }

        // 순서가 있음 -> 순열

        perm(0);

        System.out.println(sb.toString());
    }

    static StringBuilder sb = new StringBuilder();

    static void perm(int idx) {
        if(idx == M) {
            list.add(result);
            for(int i = 0; i < M; i++) {
                sb.append(result[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            result[idx] = data[i];
            perm(idx+1);
            visited[i] = false;

        }
    }

}




package Algorithm_Study.daily.CSY;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class D20250227 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            int N = sc.nextInt();
            int[] arr = new int[N];
            for(int i = 0; i < N; i++){
                arr[i] = sc.nextInt();
            }

            int ans = 0;
            Arrays.sort(arr);
//            LinkedList<Integer> list = new LinkedList<Integer>();
//            for(int i = 0; i < N; i++){
//                if(list.isEmpty()){
//                    list.add(arr[i]);
//                }else{
//                    if(list.get(i-1) > arr[i]){
//                        list.addFirst(arr[i]);
//                    }else{
//                        list.addLast(arr[i]);
//                    }
//                }
//
//            }
//            System.out.println(Arrays.toString(arr));

            System.out.print("#" + tc + " " );
            for(int i = 0; i < N; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }


    }
}
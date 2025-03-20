package Algorithm_Study.daily.LYW;

import java.util.Scanner;
import java.io.FileInputStream;
import java.util.PriorityQueue;
 

class D2025_03_19_SWEA_Heap
{
    public static void main(String args[]) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();

 
        for(int test_case = 1; test_case <= T; test_case++)
        {
         
            int X = sc.nextInt();
            PriorityQueue<Integer> pq = new PriorityQueue<>();
             
            System.out.print("#" + test_case + " ");
             
            // X만큼 반복하여 연산 수행
            int answer = 0;
            for(int i = 0; i < X; i++) {
                // 1이 들어오면 다음 수를 삽입
                int num = sc.nextInt();
                if(num == 1) {
                    pq.add(-sc.nextInt());                  
                }
                // 2가 들어오면 최댓값 출력 후 해당 키값 삭제
                else {
                    if(pq.peek() != null) {
                        answer = pq.poll();
                        System.out.print(-answer + " ");
                    } else {
                        System.out.print(-1 + " ");
                    }
                }
            }
             
            System.out.println();   
 
        }
    }
}
package Algorithm_Study.common.C20250411;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
 
public class LYW {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
             
            int n = sc.nextInt();
            int[][] container = new int[n][n];
            boolean[][] visited = new boolean[n][n]; // 방문배열
             
            // 2차원 배열입력
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    container[i][j] = sc.nextInt();
                }
            }
             
            int cnt = 0; // 행렬의 개수
            List<int[]> list = new ArrayList<>(); // 행렬 담을 리스트
             
            // 완전탐색하면서 부분행렬을 찾기
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(container[i][j] != 0 && !visited[i][j]) {
                        int x = i;
                        int y = j;
                         
                        int a = 0; // 행
                        int b = 0; // 열
                         
                        // 행 찾기
                        while(x < n && container[x][j] != 0) {
                            x++;
                            a++;
                        }
                         
                        // 열 찾기
                        while(y < n && container[i][y] != 0) {
                            y++;
                            b++;
                        }
                         
                        // 전체 블록 방문 처리
                        for (int r = i; r < i+a; r++) {
                            for (int c = j; c < j+b; c++) {
                                visited[r][c] = true;
                            }
                        }
                         
                        // a,b 리스트에 넣기
                        int[] arr = {a,b};
                        list.add(arr);
                        // 찾은 부분행렬 카운트
                        cnt++;
                    }
                }
            }
             
            // 정렬 (익명 Comparator 정의)
            Collections.sort(list, new Comparator<int[]>() {
                public int compare(int[] o1, int[] o2) {
                    int area1 = o1[0] * o1[1];
                    int area2 = o2[0] * o2[1];
 
                    if (area1 != area2) {
                        return area1 - area2;
                    } else {
                        return o1[0] - o2[0];
                    }
                }
            });
 
            // 출력
            System.out.print("#" + tc + " " + cnt);
            for (int[] arr : list) {
                System.out.print(" " + arr[0] + " " + arr[1]);
            }
            System.out.println();
 
 
        }//tc
    }//main
}
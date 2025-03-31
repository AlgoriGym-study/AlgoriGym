package Algorithm_Study.daily.LYW;


import java.util.Scanner;

public class D2025_03_27_SWEA_백만개의_정수_정렬 {
    static int N = 1000000;
    static int[] arr = new int[N];
    static int[] tmp = new int[N];
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         
        // 배열에 값 넣기
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
         
        // 병합정렬
        mergeSort(0, N-1);
        System.out.println(arr[500000]);
    }
     
    static void mergeSort(int start, int end) {
        if(start < end)  {
            int mid = (start+end) / 2;
            mergeSort(start, mid);
            mergeSort(mid+1, end);
            //병합하는 메서드
            merge(start, mid, end);
        }
    }
 
    static void merge(int start, int mid, int end) {
        // 정렬하고자 하는 부분 배열들의 시작위치를 초기화
        int L = start;
        int R = mid+1;
         
        int idx = start; // 임시공간의 인덱스
         
        while(L <= mid && R <= end) {
            if(arr[L] <= arr[R]) {
                tmp[idx++] = arr[L++];
            } else {
                tmp[idx++] = arr[R++];
            }
        } // 한쪽 구간은 전부 끝
         
        if (L <= mid) {
            for(int i = L; i <= mid; i++) {
                tmp[idx++] = arr[i];
            }
        } else {
            for(int i = R; i <= end; i++) {
                tmp[idx++] = arr[i];
            }
        } // 남은 구간 다 털기
         
        for(int i = start; i <= end; i++) {
            arr[i] = tmp[i];
        }// 원본에 덮기  
    }
}
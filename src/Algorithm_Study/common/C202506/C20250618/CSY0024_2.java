package Algorithm_Study.common.C202506.C20250618;

import java.util.Arrays;

public class CSY0024_2 {
    static int[] discount = {10, 20, 30, 40}; // 이모티콘 할인율 배열
    static int people = 0; // 최대 구독자 수
    static int revenue = 0; // 최대 매출액

    public static void main(String[] args) {
        int[][] users = {{40, 10000}, {25, 10000}};
        int[] emotions = {7000, 9000};

        int[] dis = new int[emotions.length]; // 각 이모티콘에 대한 할인율 저장
        dfs(0, dis, users, emotions); // 모든 할인율 조합 탐색

        int[] answer = {people,revenue};
        System.out.println(Arrays.toString(answer));
    }

    // dfs 조합 완탐
    static void dfs(int dp, int[] dis, int[][] users, int[] emotions){
        if(dp == emotions.length){
            eva(dis, users, emotions);
            return;
        }

        for(int rate : discount){
            dis[dp] = rate; // 각 이모티콘별로 4개의 할인율 적용한 것을 재귀 탐색
            dfs(dp+1, dis, users, emotions);
        }
    }

    // 해당 할인율 조합에 대한 가입자 수와 매출 계산
    static void eva(int[] dis, int[][] users, int[] emotions){
        int p = 0; // 가입자 수
        int r = 0; // 매출

        for(int[] user : users){
            int min = user[0]; // 최소 할인율 조건
            int change = user[1]; // 구독 전환 기준
            int sum = 0;

            for(int i = 0; i < emotions.length; i++){
                int rate = dis[i];
                if(rate >= min){
                    sum += emotions[i] * (100 - rate) / 100;
                }
            }

            if(sum >= change){ // 구입 총액이 전환 기준 넘으면 구독자 수 증가.
                p++;
            }else{
                r += sum;
            }

            if(p > people){ // 만약 이번 조합이 기존보다 높으면 갱신
                people = p;
                revenue = r;
            }else if(p == people){ // 구독자수가 같으면 매출액 중 더 높은 걸로 갱신
                revenue = Math.max(r, revenue);
            }

        }
    }
}

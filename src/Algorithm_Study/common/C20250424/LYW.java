package Algorithm_Study.common.C20250424;

import java.util.*;

public class LYW {
 
    static int max;                           
    static char[] ch_input;                   
    static HashSet<String> visited;           
 
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;                               
        T = sc.nextInt();
 
        for (int tc = 1; tc <= T; tc++) {
            ch_input = sc.next().toCharArray();     // 숫자를 문자 배열로 입력받음
            int win = sc.nextInt();                // 바꿀 수 있는 횟수
            max = 0;                               
            visited = new HashSet<>();             
 
            dfs(win, 0);                          
 
            System.out.println("#" + tc + " " + max);
        }
    }
 
    private static void dfs(int win, int depth) {
        // 종료 조건 : 바꿀 수 있는 횟수만큼 다 바꿨다면 최대값 업데이트 후 리턴
        if (depth == win) {
            max = Math.max(max, Integer.parseInt(new String(ch_input))); 
            return;
        }
 
        // 현재 상태를 String으로 만들어서 중복 체크
        String check = new String(ch_input);
        if (visited.contains(check)) return;        // 이미 방문한 상태면 리턴
        else visited.add(check);                   // 처음 방문한 상태라면 visited에 추가
 
        // 가능한 모든 자리쌍에 대해서 swap 시도
        for (int i = 0; i < ch_input.length - 1; i++) {
            for (int j = i + 1; j < ch_input.length; j++) {
                swap(i, j);                        // swap
                dfs(win, depth + 1);               // 다음 단계로 진행 (depth 1 증가)
                swap(i, j);                        // 원상복구 (백트래킹)
            }
        }
    }
 
    private static void swap(int a, int b) {
        // 자리 a와 b를 swap
        char tmp = ch_input[a];
        ch_input[a] = ch_input[b];
        ch_input[b] = tmp;
    }
}


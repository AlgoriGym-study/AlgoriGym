package Algorithm_Study.common.C202504.C20250424;

import java.util.*;
import java.io.*;

public class CSY {

    static int max;
    static char[] ch_input;
    static Set<String> visited;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().split(" ")[0]);

        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ch_input = st.nextToken().toCharArray(); // 숫자
            int N = Integer.parseInt(st.nextToken()); // 교환 횟수
            max = 0;
            visited = new HashSet<>(); // set으로 방문 체크

            dfs(N, 0);

            System.out.println("#" + tc + " " + max);
        }
    }

    private static void dfs(int N, int depth) {
        if (depth == N){ // 교환 횟수에 다다르면 끝!
            max = Math.max(max, Integer.parseInt(new String(ch_input))); // 최대값으로 갱신
            return;
        }

        String check = new String(ch_input); // 현재 char 배열을 스트링으로!
        if (visited.contains(check)) return; // set에 체크가 방문 체크 되어 있으면 리턴
        else visited.add(check); //아니면 방문 체크

        for(int i=0; i<ch_input.length-1; i++){
            for(int j=i+1; j<ch_input.length; j++){
                swap(i, j); // 맨 앞부터 그 뒤로 한칸씩 가며 스왑
                dfs(N, depth+1); // 그 바꾼 상태에서 N번까지 dfs
                swap(i, j); // 백트래킹
            }
        }
    }

    private static void swap(int a, int b) {
        char tmp = ch_input[a];
        ch_input[a] = ch_input[b];
        ch_input[b] = tmp;
    }
}


package Algorithm_Study.daily.YHS.before;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

class D20250314_대칭_차집합 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> setA = new HashSet<>();
        Set<Integer> setB = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            setA.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            setB.add(Integer.parseInt(st.nextToken()));
        }

        int cnt = 0;
        for (int num : setA) {
            if (!setB.contains(num)) {
                cnt += 1;
            }
        }

        for (int num : setB) {
            if (!setA.contains(num)) {
                cnt += 1;
            }
        }

        System.out.println(cnt);
    }
}
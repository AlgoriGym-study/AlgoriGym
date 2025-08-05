package Algorithm_Study.common.C202507.C20250723;

import java.io.*;
import java.util.*;

public class LYW0035_2 {
    static int[] friend;
    static List<Integer>[] enemy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        friend = new int[N + 1];
        enemy = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            friend[i] = i;
            enemy[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            String line = br.readLine();
            StringTokenizer st = new StringTokenizer(line);

            char command = st.nextToken().charAt(0);
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            switch(command) {
                case 'F':
                    union(num1, num2);
                    break;
                case 'E' :
                    for (int j = 0; j < enemy[num1].size(); j++) {
                        union(enemy[num1].get(j), num2);
                    }

                    for (int j = 0; j < enemy[num2].size(); j++) {
                        union(enemy[num2].get(j), num1);
                    }

                    enemy[num1].add(num2);
                    enemy[num2].add(num1);

            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < N + 1; i++) {
            set.add(find(i));
        }

        bw.write(String.valueOf(set.size()));
        bw.flush();
        bw.close();
        br.close();
    }

    static int find(int num) {
        if(friend[num] == num) return num;
        return friend[num] = find(friend[num]);
    }

    static void union(int num1, int num2) {
        int fx = find(num1);
        int fy = find(num2);
        if(fx != fy) friend[fy] = fx;
    }

}

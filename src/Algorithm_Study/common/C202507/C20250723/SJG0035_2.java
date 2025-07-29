package Algorithm_Study.common.C202507.C20250723;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class SJG0035_2 {
    static int n, m;
    static List<List<Integer>> friends, enemies;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        
        friends = new ArrayList<>();
        enemies = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            friends.add(new ArrayList<>());
            enemies.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char type = st.nextToken().charAt(0);
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());
            
            if (type == 'F') {
                friends.get(p).add(q);
                friends.get(q).add(p);
            } else {
                enemies.get(p).add(q);
                enemies.get(q).add(p);
            }
        }
        
        visited = new boolean[n + 1];
        int teams = 0;
        
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                dfs(i);
                teams++;
            }
        }
        
        System.out.println(teams);
    }
    
    static void dfs(int node) {
        visited[node] = true;
        
        // 직접 친구들 방문
        for (int friend : friends.get(node)) {
            if (!visited[friend]) {
                dfs(friend);
            }
        }
        
        // 원수의 원수는 친구 (적의 적은 친구)
        for (int enemy : enemies.get(node)) {
            for (int enemyOfEnemy : enemies.get(enemy)) {
                if (!visited[enemyOfEnemy]) {
                    dfs(enemyOfEnemy);
                }
            }
        }
    }
}

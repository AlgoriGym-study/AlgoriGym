package Algorithm_Study.common.C202510.C20251001;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class SJG0049 {
    static class Node {
        int to;
        int weight;
        
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
    
    static List<List<Node>> tree;
    static boolean[] visited;
    static int maxDist;
    static int farthestNode;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int V = Integer.parseInt(br.readLine());
        
        tree = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            
            while (true) {
                int to = Integer.parseInt(st.nextToken());
                if (to == -1) break;
                
                int weight = Integer.parseInt(st.nextToken());
                tree.get(from).add(new Node(to, weight));
            }
        }
        
        visited = new boolean[V + 1];
        maxDist = 0;
        farthestNode = 1;
        dfs(1, 0);
        
        visited = new boolean[V + 1];
        maxDist = 0;
        dfs(farthestNode, 0);
        
        System.out.println(maxDist);
    }
    
    static void dfs(int node, int dist) {
        visited[node] = true;
        
        if (dist > maxDist) {
            maxDist = dist;
            farthestNode = node;
        }
        
        for (Node next : tree.get(node)) {
            if (!visited[next.to]) {
                dfs(next.to, dist + next.weight);
            }
        }
    }
}
package Algorithm_Study.common.C202503.C20250320;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SJG {
	static int[] tree;
    static Map<Integer, List<Integer>> child;
    static int n1, n2;
    static int subtree;
    static int sf;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String[] inputVEN = br.readLine().split(" ");
            int V = Integer.parseInt(inputVEN[0]);
            int E = Integer.parseInt(inputVEN[1]);
            n1 = Integer.parseInt(inputVEN[2]);
            n2 = Integer.parseInt(inputVEN[3]);
            
            tree = new int[V+1];
            child = new HashMap<>();
            for(int i = 1; i <= V; i++) child.put(i, new ArrayList<>());
            
            String[] input = br.readLine().split(" ");
            for(int i = 1; i < E*2; i+=2) {
                int idx = Integer.parseInt(input[i-1]);
                int childNode = Integer.parseInt(input[i]);
                
                tree[childNode] = idx;
                child.get(idx).add(childNode);
            }
            
            sf = findSf(n1, n2);
            
            subtree = countSubTreeSize(sf);
            sb.append("#").append(test_case).append(" ").append(sf).append(" ").append(subtree).append("\n");
		}
        br.close();
        System.out.print(sb);
	}
    
    // 공통 조상 찾기
    private static int findSf(int n1, int n2) {
        boolean[] visited = new boolean[tree.length];
        
        while(n1 > 0) {
            visited[n1] = true;
            n1 = tree[n1];
        }
        
        while(n2 > 0) {
            if(visited[n2]) return n2;
            n2 = tree[n2];
        }
        
        return 1;
    }
    
    // 서브트리 크기 계산
    private static int countSubTreeSize(int nodeNum) {
        int cnt = 1;
        for(int c : child.get(nodeNum)) cnt += countSubTreeSize(c);
        return cnt;
    }
}

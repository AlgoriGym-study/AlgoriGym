package Algorithm_Study.daily.SJG;

import java.io.*;
import java.util.*;

public class D20250410 {
	static class Node {
		int idx, weight;
		public Node(int idx, int weight) {
			this.idx = idx;
			this.weight = weight;
		}
	}

	static int V, E, K;
	static List<Node>[] adj;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] inputVE = br.readLine().split(" ");
		V = Integer.parseInt(inputVE[0]);
		E = Integer.parseInt(inputVE[1]);
		K = Integer.parseInt(br.readLine());

		adj = new ArrayList[V+1];
		for(int i = 1; i <= V; i++) adj[i] = new ArrayList<>();
		dist = new int[V+1];
		for(int i = 0; i < V+1; i++) dist[i] = INF;
		dist[K] = 0;
	
		for(int i = 0; i < E; i++) {
			String[] input = br.readLine().split(" ");
			int from = Integer.parseInt(input[0]);
			int to = Integer.parseInt(input[1]);
			int w = Integer.parseInt(input[2]);
			adj[from].add(new Node(to, w));
		}
		
		dijkstra(K);
	
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				sb.append("INF").append('\n');
			} else {
				sb.append(dist[i]).append('\n');
			}
		}
		System.out.print(sb);
		br.close();
	}
		    
	private static void dijkstra(int startNode) {
		dist[startNode] = 0;
		        
		Queue<Node> pq = new PriorityQueue<>((n1, n2) -> {
			return n1.weight - n2.weight;
		});
		pq.offer(new Node(startNode, 0));
		
		while(!pq.isEmpty()) {
			Node curr = pq.poll();
			int currIdx = curr.idx;
			int currWeight = curr.weight;
			
			if(currWeight > dist[currIdx]) continue;
			for (Node neighborNode : adj[currIdx]) {
				int neighborIdx = neighborNode.idx;
				int edgeWeight = neighborNode.weight;
				
				if (dist[currIdx] + edgeWeight < dist[neighborIdx]) {
					dist[neighborIdx] = dist[currIdx] + edgeWeight;
					pq.offer(new Node(neighborIdx, dist[neighborIdx]));
				}
			}
		}
	}
}

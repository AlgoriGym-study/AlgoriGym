package Algorithm_Study.daily.PJE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
// 백준 바이러스
public class D20250323 {
	static Map<Integer, List<Integer>> map;
	static boolean [] visited;
	static int ans,cnt;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int N = sc.nextInt();
		visited = new boolean [num+1];
		map = new HashMap<Integer, List<Integer>>();
		
		for (int i = 0; i <N ; i++) {
			int n1 = sc.nextInt();
			int n2 = sc.nextInt();
			
			// 키: n1 / 값 : List (만약 n1 키 없으면 새로운 list 만들고 있으면 그 리스트에 값넣기)
			if (!map.containsKey(n1)) {
			    map.put(n1, new ArrayList<>());
			    map.get(n1).add(n2);
			}else {
				map.get(n1).add(n2);
				
			}

			// 키 : n2 / 값 : List
			if (!map.containsKey(n2)) {
			    map.put(n2, new ArrayList<>());
			}
			map.get(n2).add(n1);
			
		}
		
//		입력값 확인
//		for (int idx : map.keySet()) {
//			List<Integer> list = map.get(idx);
//			System.out.print("key: "+idx);
//			System.out.println(" val: "+list+" ");
//		}
		
		
		ans = 0;
		getnum(1);
		System.out.print(ans);
					
		
	}
	static void getnum(int root) {
		//1을 키로하는 val들을 찾고 그걸 다시 키로해서 null일때까지 찾기
		List<Integer> list =  map.get(root);
		if(list == null) return;
		
		visited[root] = true; 

		for (int i = 0; i <list.size(); i++) {
			int key = list.get(i);
			if(!visited[key]) {
				ans++;
				getnum(key);
			}
		}
	}
}

package Algorithm_Study.common.C20250320;

import java.util.Arrays;
import java.util.Scanner;
//SWEA 공통조상 
public class PJE {
	static int ans, num1, num2;
	static int [] left;
	static int [] right;
	static int [] tree;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for (int tc = 1; tc <= 1; tc++) {
	
			int V = sc.nextInt(); // 정점의 갯수
			int E = sc.nextInt(); // 간선의 갯수
			num1 = sc.nextInt(); // 공통조상 정점 번호1 
			num2 = sc.nextInt(); // 공통조상 정점 번호2
			
			tree = new int [V+1];
			left = new int [V+1];
			right = new int [V+1];
			
			// 정점 노드 = 트리, 왼쪽부터 채워지게 저장(정렬X)
			// 1 2 1 3 2 4 3 5 3 6 4 7 7 12 5 9 5 8 6 10 6 11 11 13
			for (int i = 0; i < E; i++) {
				int idx = sc.nextInt();
				int num = sc.nextInt();
				tree[idx] = idx;
				if(left[idx]==0) 
					left[idx] = num;
				else if(right[idx]==0)
					right[idx] = num;
			}
			//저장 끝 
			
			// 공통조상 찾기 밑으로 내려가면서 num1,num2 찾기 
			int common = find(1);
			// 공통조상 찾았으면 내려가면서 사이즈 체크하기
			int size  = cntSize(common);
			System.out.println("#"+tc+" "+common+" "+size);
//			System.out.println(Arrays.toString(tree));
//			System.out.println(Arrays.toString(left));
//			System.out.println(Arrays.toString(right));
		}
	}
	static int cntSize(int root) {
		if(root == 0) 
			return 0;
		return 1+cntSize(left[root])+cntSize(right[root]); 
	}
	static int find(int root) {
		//재귀 전 
		if(root == 0) //맨 아래 
			return 0;
		if(root == num1||root==num2) //정점번호를 찾았다면 루트 숫자 반환 
			return root;
		
		
		int leftValue = 0,rightValue=0;
		
		//재귀
		if(left[root]!=0) {
			leftValue = find(left[root]);
		}
		if(right[root]!=0) {
			rightValue = find(right[root]);
		}
		
		//재귀 후
		if(leftValue !=0 && rightValue != 0) //왼쪽 오른쪽 값 모두 0이 아니라는 뜻은 왼쪽 오른쪽 노드에서 둘다 정점번호가 반환되었다는 뜻
			return root;
		else if(leftValue != 0 ) { //왼쪽이 0이 아니라는 의미는 값이 있다는 의미. 왼쪽 값을 반환 
			return leftValue;
		}else { // 왼쪽 값 0 = 값이 없음 => 오른쪽 값을 반환
			return rightValue;
		}
		
		
	}
	
}

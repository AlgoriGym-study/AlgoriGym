package Algorithm_Study.common.C202507.C20250723;
import java.util.*;

// 백준 닭싸움 팀 정하기
public class PJE0035 {

    static int N, M, result = 0;
    static int[] parent;         // 부모 배열
    static int[] team;           // 각 집합(팀)의 크기 저장
    static boolean[][] rivals; // 적 배열

    public static void main(String[] args) {
      
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();  // 학생 수
        M = sc.nextInt();  // 관계 수
        
        team = new int[N + 1];
        parent = new int[N + 1]; 
        rivals = new boolean[N + 1][N + 1];

        // 초기화
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 관계 입력
        for (int i = 0; i < M; i++) {
            String relationship = sc.next();  // F E
            int student1 = sc.nextInt();
            int student2 = sc.nextInt();

            if (relationship.equals("E")) { // 적
                rivals[student1][student2] = true;
                rivals[student2][student1] = true;
            } else {                       // 친구
                makeFriend(student1, student2);
            }
        }

  	   for (int i = 1; i <= N; i++) {
      	  for (int j = 1; j <= N; j++) {
        	  
            if (!rivals[i][j]) continue;
          	for (int k = 1; k <= N; k++) {
              // 적의 적은 친구
              if (rivals[j][k]) makeFriend(i, k);
              if (rivals[i][k]) makeFriend(j, k);  
          	}
      		}
  	    }

        // 대표자 기준으로 팀 인원 카운트
        for (int i = 1; i <= N; i++) {
            team[findParent(i)]++;
        }

        // 대표자가 다른 팀 개수 세기
        for (int i : team) {
            if (i != 0) {
                result++;
            }
        }

        System.out.println(result);
    }

    // 유니온: 친구만들기 (같은 팀으로 묶음)
    static void makeFriend(int student1, int student2) {
        if (findParent(student1) != findParent(student2)) {
                parent[findParent(student1)] = findParent(student2);      
        }
    }

    static int findParent(int i) {
        if (parent[i] != i) {
            return parent[i] = findParent(parent[i]);
        }
        return i;
    }
}

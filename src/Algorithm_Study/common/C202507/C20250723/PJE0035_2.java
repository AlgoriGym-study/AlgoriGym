package Algorithm_Study.common.C202507.C20250723;
import java.util.*;

// 백준 닭싸움 팀 정하기 복습
public class PJE0035_2{
    static int n,m;
    static int [] parent;
    static int [][] enemies;
  
    public static void main(String[] args){
         
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt(); // 학생 수 
        m = sc.nextInt(); // 인간관계 
        enemies = new int [n+1][n+1]; // 적 배열
        parent = new int[n + 1]; // 부모 배열
    
        
        // 초기화
        for(int i = 1; i <= n; i++){
            parent[i]=i;
        }
            
        // 입력
        for(int i = 0; i < m; i++){
            String relation = sc.next(); // 관계 
            int s1 = sc.nextInt(); // 학생1
            int s2 = sc.nextInt(); // 학생2
            
            if(relation.equals("F")){
                makeFriends(s1,s2);
            }else{
                enemies[s1][s2] = 1;
                enemies[s2][s1] = 1;
            }
            
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j<=n; j++){
                
                if(enemies[i][j]==0) continue;
                // 적의 적은 친구
                for(int k = 1; k <= n; k++){
                    if(enemies[i][k]==1) makeFriends(j,k);
                }
            }
        }
      
        Set<Integer> set = new HashSet<>();
        
        for(int i = 1; i<=n; i++){
            set.add(findParent(i));
        }
        
        System.out.println(set.size());
    }
    
    // 유니온
    static void makeFriends(int s1, int s2){
        if(findParent(s1)!=findParent(s2)){
            parent[findParent(s1)] = findParent(s2);
        }
    }
    
    static int findParent(int i){
        if(parent[i]!=i){
            return parent[i] = findParent(parent[i]);
        }
        return i;
    }
}

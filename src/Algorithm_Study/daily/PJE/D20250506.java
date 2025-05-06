package Algorithm_Study.daily.PJE;

import java.util.Scanner;

public class D20250506 {
	  public static void main(String[] args){
	        Scanner sc = new Scanner(System.in);

	        for(int tc = 1; tc <= 10; tc++){
	           sc.nextLine();
	            String str = sc.nextLine(); // 찾을 단어
	            String sen = sc.nextLine(); // 전체 문장

	            int cnt = 0;
	            // 브루트 포스
	            for(int i = 0; i <= sen.length() - str.length(); i++){
	                boolean flag = true;
	                for(int j = 0; j < str.length(); j++){
	                    if(sen.charAt(i + j) != str.charAt(j)){
	                        flag = false;
	                        break;
	                    }
	                }
	                if(flag) cnt++;
	            }

	            System.out.println("#" + tc + " " + cnt);
	        }

	    }
}

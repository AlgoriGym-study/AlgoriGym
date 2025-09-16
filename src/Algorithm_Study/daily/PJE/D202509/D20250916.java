package Algorithm_Study.daily.PJE.D202509;
public class D20250916 {
		public int solution(int num) {
			int cnt = 0;
			long n = num;
            
			while(n!=1 && cnt<500){
				if(n%2==0)
					n = n/2;
				else
					n = n*3 + 1;
				
				cnt++;
			}
			
			return cnt > 500 ? -1 : cnt;
		}
	}

package Algorithm_Study.daily.CSY.April;


    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D20250408_재귀의귀재 {
        public static int recursion(String s, int l, int r){
            cnt++;
            if(l >= r) return 1;
            else if(s.charAt(l) != s.charAt(r)) return 0;
            else return recursion(s, l+1, r-1);
        }


        public static int isPalindrome(String s){
            return recursion(s, 0, s.length()-1);
        }

        static int cnt;
        public static void main(String[] args) throws NumberFormatException, IOException{

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int N = Integer.parseInt(br.readLine());
            StringBuilder st = new StringBuilder();
            for(int i = 0; i < N; i++) {
                cnt = 0;
                String str = br.readLine();
                int ans = isPalindrome(str);
                st.append(ans).append(" ").append(cnt).append("\n");
            }
            System.out.println(st.toString());


        }
    }

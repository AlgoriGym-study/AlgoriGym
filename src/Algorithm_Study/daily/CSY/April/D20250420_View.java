package Algorithm_Study.daily.CSY.April;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D20250420_View {

        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();


            for(int tc = 1; tc <= 10; tc++) {
                sb.append("#").append(tc).append(" ");
                int N = Integer.parseInt(br.readLine()); // 건물의 개수 1000개 이하 , 높이는 255이하
                int[] buildings = new int[N];
                // 위에서부터 보고, 좌우로 +-2했을 때, 건물의 높이보다 작으면 오케이 아니면 break;

                StringTokenizer st = new StringTokenizer(br.readLine());

                for(int i = 0; i < N; i++) {
                    buildings[i] = Integer.parseInt(st.nextToken());
                }// input

                int ans = 0;
                for(int b = 2; b < N-2; b++) {
                    int curr = buildings[b];
                    while(curr > 0) {
                        if(curr <= buildings[b-2] || curr <= buildings[b-1] || curr <= buildings[b+1] || curr <= buildings[b+2])
                            break;
                        curr--;
                        ans++;
                    }
                }

                sb.append(ans).append("\n");
            }
            System.out.println(sb.toString());
        }

    }

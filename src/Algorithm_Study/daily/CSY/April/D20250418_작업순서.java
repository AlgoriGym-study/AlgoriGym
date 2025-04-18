package Algorithm_Study.daily.CSY.April;



    import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class D20250418_작업순서 {

        static int[] indegree; // 진입차수 저장할 배열
        static Queue<Integer> result;

        static int V, E;

        static ArrayList<ArrayList<Integer>> adjList;

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            for (int tc = 1; tc <= 10; tc++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                V = Integer.parseInt(st.nextToken());
                E = Integer.parseInt(st.nextToken());

                adjList = new ArrayList<>();
                for(int i = 0; i <= V; i++) {
                    adjList.add(new ArrayList<>());
                }

                indegree = new int[V+1];
                result = new ArrayDeque<>();

                st = new StringTokenizer(br.readLine());

                for (int i = 0; i < E; i++) {
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());

                    adjList.get(a).add(b);
                    indegree[b]++;
                }// input

                bsf();
                sb.append("#").append(tc).append(" ");

                while(!result.isEmpty()) {
                    sb.append(result.poll()).append(" ");
                }
                sb.append("\n");
            }
            System.out.print(sb);
        }

        private static void bsf() {
            Queue<Integer> q = new ArrayDeque<>();
            for(int i = 1; i <= V; i++) {
                if(indegree[i] == 0) q.add(i);
            }

            while(!q.isEmpty()) {
                int cur = q.poll();
                result.add(cur);

                for(int next : adjList.get(cur)){
                    --indegree[next];

                    if(indegree[next] == 0) q.add(next);
                }
            }
        }


    }
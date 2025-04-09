package Algorithm_Study.daily.CSY.April;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class D20250409_바이러스 {
        static List<Integer>[] adj;
        static boolean[] visited;
        static int ans;

        public static void main(String[] args) throws NumberFormatException, IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            int N = Integer.parseInt(br.readLine());
            int V = Integer.parseInt(br.readLine());

            adj = new ArrayList[N+1];
            visited = new boolean[N+1];

            for(int i = 0; i < N+1; i++) {
                adj[i] = new ArrayList<>();
            }

            StringTokenizer st;
            for(int i = 0; i < V; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                adj[A].add(B);
                adj[B].add(A);
            }
            ans = 0;

            dfs(1);
            visited[1] = false;

            for(boolean v : visited) {
                if(v) ans++;
            }

            System.out.println(ans);

        }

        static void dfs(int start) {
            Stack<Integer> s = new Stack<>();
            for(int i : adj[start]) {
                visited[i] = true;
                s.add(i);
            }

            while(!s.isEmpty()) {
                int cur = s.pop();

                for(int c : adj[cur]) {
                    if(visited[c]) continue;
                    visited[c] = true;
                    s.add(c);
                }
            }

        }

    }


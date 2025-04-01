package Algorithm_Study.common.C20250401;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import _0401.PJE.Virus;

//경쟁적전염
public class PJE {
	static int[][] map;
	// 상하좌우
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Virus implements Comparable<Virus> {

		int num, s, r, c;

		Virus(int num, int s, int r, int c) {
			this.num = num;
			this.s = s;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(Virus o) {
			return Integer.compare(this.s, o.s);
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 맵 크기
		int K = sc.nextInt(); // 바이러스 종류 1 ~ K 중 하나

		map = new int[N][N];
		List<Virus> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0) {
					int num = map[i][j]; // 바이러스 숫자
					list.add(new Virus(num, 0, i, j));
					// 바이러스 숫자 오름차순으로 좌표 저장
				}
			}
		}
		int S = sc.nextInt(); // S초
		int X = sc.nextInt(); // x좌표
		int Y = sc.nextInt(); // y좌표 해당 좌표의 바이러스 종류 출력
		// 입력

        Collections.sort(list); //번호순 정렬
        Queue<Virus> q = new LinkedList<>(list);

        // 같은레벨(S)에 있을때 바이러스 번호가 낮은것부터 퍼지게
        while (!q.isEmpty()) {

            Virus virus = q.poll();
            
            if (virus.s == S) break; //S초동안 수행하면 bfs 멈춤

            for (int d = 0; d < 4; d++) {

                int nr = virus.r + dr[d];
                int nc = virus.c + dc[d];

                if (nr >= 0 && nr < N && nc >= 0 && nc < N && map[nr][nc] == 0) {

                    map[nr][nc] = virus.num;
                    q.add(new Virus(virus.num, virus.s + 1, nr, nc));

                }

            }

        }
		
		
		
		System.out.println(map[X - 1][Y - 1]);

	}
}

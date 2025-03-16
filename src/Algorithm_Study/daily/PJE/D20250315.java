package Algorithm_Study.daily.PJE;
import java.util.Scanner;

public class D20250315 {
	static int H, W; // 행 열
	static int row, col; // 전차 위치
	static char[][] map; // 맵
	static char tankDir; // 전차 방향

	// 위 아래 왼쪽 오른쪽
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static char[] dir = { '^', 'v', '<', '>' };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			H = sc.nextInt();
			W = sc.nextInt();

			map = new char[H][W];
			row = col = 0;
			tankDir = '.';
			for (int i = 0; i < H; i++) {
				String str = sc.next();
				for (int j = 0; j < W; j++) {
					map[i][j] = str.charAt(j);

					if (map[i][j] == '^' || map[i][j] == 'v' || map[i][j] == '<' || map[i][j] == '>') {
						row = i;
						col = j;
						tankDir = map[i][j];
					}
				}
			}
			int N = sc.nextInt();
			char[] c = sc.next().toCharArray();
			// 입력 끝

			// 이동
			for (int i = 0; i < N; i++) {
				switch (c[i]) {
				case 'U':
					move(0);
					break;
				case 'D':
					move(1);
					break;
				case 'L':
					move(2);
					break;
				case 'R':
					move(3);
					break;
				case 'S':
					shoot();
					break;
				}
			}
			System.out.print("#" + tc + " ");
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
// 벽에 충돌하거나 맵 바깥으로 나가면 탱크 멈춤
	private static void shoot() {
		// 현재 탱크방향 인덱스 찾기위해 검사
		int dirIdx = 0;
		for (int i = 0; i < 4; i++) {
			if (tankDir == dir[i]) {
				dirIdx = i;
				break;
			}
		}
		//
		
		int nx = row;
		int ny = col;

		while (true) {
			nx += dx[dirIdx];
			ny += dy[dirIdx];
			
			//맵 바깥
			if (nx < 0 || nx >= H || ny < 0 || ny >= W)
				return;
			//포탄
			if (map[nx][ny] == '#')
				return;
			if (map[nx][ny] == '*') {
				map[nx][ny] = '.';
				return;
			}

		}
	}

//	static int num;

	private static void move(int d) {
		// 탱크방향 갱신
		tankDir = dir[d];

//		num++;
//		System.out.println(num +"번째: "+ tankDir);

		// 다음 인덱스
		int nx = row + dx[d];
		int ny = col + dy[d];

		// 범위 안에 있고 평지라면
		if ((nx >= 0 && ny >= 0 && nx < H && ny < W) && map[nx][ny] == '.') {
			map[row][col] = '.'; // 현재 위치를 평지로 만들고
			row = nx; // 인덱스 갱신
			col = ny;
		}
		map[row][col] = tankDir; // 바뀐 인덱스 위치에 탱크 표시 (만약 인덱스 바뀌지 않더라도 방향은 바뀐채로 종료되어야함)
	}
}

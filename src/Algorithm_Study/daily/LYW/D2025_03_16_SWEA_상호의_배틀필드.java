package Algorithm_Study.daily.LYW;
import java.util.Arrays;
import java.util.Scanner;

public class D2025_03_16_SWEA_상호의_배틀필드 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {

			int H = sc.nextInt();
			int W = sc.nextInt();
			char[][] map = new char[H][W];

			for (int i = 0; i < H; i++) {
				map[i] = sc.next().toCharArray();
			}

			int N = sc.nextInt();
			char[] move = sc.next().toCharArray();

			int x = 0;
			int y = 0;
			char tank = '.';

			boolean found = false;
			for (int i = 0; i < H && !found; i++) {
			    for (int j = 0; j < W; j++) {
			        if (map[i][j] == '<' || map[i][j] == '^' || map[i][j] == '>' || map[i][j] == 'v') {
			            x = i;
			            y = j;
			            tank = map[i][j];
			            found = true;
			            break;  // 내부 루프 종료
			        }
			    }
			}


//			System.out.println("탱크위치 및 탱크상태 : (" + x + ", " + y + ") : " + tank);
//			System.out.println(Arrays.toString(move));

			// 움직임 배열을 값들을 하나씩 꺼내서 해당 행동 취하기
			for (int i = 0; i < move.length; i++) {
				switch (move[i]) {
				case 'U': { // 위 방향
					map[x][y] = '^';
					tank = '^';
					if (x - 1 >= 0 && x - 1 < H && map[x - 1][y] == '.') {
						map[x - 1][y] = '^'; // 탱크 이동
						map[x][y] = '.'; // 이전 탱크 위치 평지로 초기화
						x = x - 1; // 탱크 변경 위치 초기화
					}
					break;
				}

				case 'D': { // 아래 방향
					map[x][y] = 'v';
					tank = 'v';
					if (x + 1 >= 0 && x + 1 < H && map[x + 1][y] == '.') {
						map[x + 1][y] = 'v';
						map[x][y] = '.';
						x = x + 1; // 탱크 변경 위치 초기화
					}
					break;
				}

				case 'L': { // 왼쪽 방향
					map[x][y] = '<';
					tank = '<';
					if (y - 1 >= 0 && y - 1 < W && map[x][y - 1] == '.') {
						map[x][y - 1] = '<';
						map[x][y] = '.';
						y = y - 1; // 탱크 변경 위치 초기화
					}
					break;
				}

				case 'R': { // 오른쪽 방향
					map[x][y] = '>';
					tank = '>';
					if (y + 1 >= 0 && y + 1 < W && map[x][y + 1] == '.') {
						map[x][y + 1] = '>';
						map[x][y] = '.';
						y = y + 1; // 탱크 변경 위치 초기화
					}
					break;
				}

				case 'S': { // 포탄 발사
					if (tank == '^') {
						int a = 1;
						while (x - a >= 0) {
							if (map[x - a][y] == '#') { // 강철벽인 경우 break
								break;
							} else if (map[x - a][y] == '*') { // 벽돌 벽인 경우 땅으로 변경
								map[x - a][y] = '.';
								break;
							}
							a++;
						}
					} else if (tank == 'v') {
						int a = 1;
						while (x + a >= 0) {
							if (map[x + a][y] == '#') { // 강철벽인 경우 break
								break;
							} else if (map[x + a][y] == '*') { // 벽돌 벽인 경우 땅으로 변경
								map[x + a][y] = '.';
								break;
							}
							a++;
						}
					} else if (tank == '<') {
						int a = 1;
						while (y - a >= 0) {
							if (map[x][y - a] == '#') { // 강철벽인 경우 break
								break;
							} else if (map[x][y - a] == '*') { // 벽돌 벽인 경우 땅으로 변경
								map[x][y - a] = '.';
								break;
							}
							a++;
						}
					} else if (tank == '>') {
						int a = 1;
						while (y + a >= 0) {
							if (map[x][y + a] == '#') { // 강철벽인 경우 break
								break;
							} else if (map[x][y + a] == '*') { // 벽돌 벽인 경우 땅으로 변경
								map[x][y + a] = '.';
								break;
							}
							a++;
						}
					}
					break;
				}

				}// switch
			} // for
			
			// 맵 출력
			System.out.print("#" + tc + " ");
			
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}

		} // tc
	}
}

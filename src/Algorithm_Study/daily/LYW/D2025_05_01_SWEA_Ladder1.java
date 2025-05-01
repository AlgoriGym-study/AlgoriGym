package Algorithm_Study.daily.LYW;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class D2025_05_01_SWEA_Ladder1 {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int[][] arr = new int[100][100];

			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int door = 0;
			for (int i = 0; i < 100; i++) {
				if (arr[0][i] == 1) {
					int r = 0;
					int c = i;
					while (r < 99) {
						if (c < 99 && arr[r][c + 1] == 1) {
							while (c < 99 && arr[r][c + 1] == 1) {
								c++;
							}
						} else if (c > 0 && arr[r][c - 1] == 1) {
							while (c > 0 && arr[r][c - 1] == 1) {
								c--;
							}
						}
						r++;
					}
					if (arr[r][c] == 2) {
						door = i;
						break;
					}
				}
			}
			System.out.println("#" + tc + " " + door);
		}

	}
}
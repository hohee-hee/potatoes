

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };
		int[][] arr = new int[102][102];

		// 모든 값을 돌면서 생종이가 생선되는 곳에 1을 넣어준다.
		for (int tc = 0; tc < T; tc++) {
			int r = sc.nextInt();
			int c = sc.nextInt();
			for (int i = r + 1; i <= r + 10; i++) {
				for (int j = c + 1; j <= c + 10; j++) {
					arr[i][j] = 1;
				}
			}
		}

		// 사방탐색을 하면서 값이 1과 0ㅇ이 같이 나오는 경우 태두리 라고 인식
		// 0만 1만 나오는 경우는 카운트 하지 않음
		int cnt = 0;
		for (int i = 0; i < 102; i++) {
			for (int j = 0; j < 102; j++) {
				// 테두리는 값이 1인 상태에서 발생된다.
				if (arr[i][j] == 1) {
					// 4방탐색을 해준다.
					for (int k = 0; k < 4; k++) {
						int drr = i + dr[k];
						int dcc = j + dc[k];
						if (drr > 0 && dcc > 0 && drr <= 102 && dcc <= 102) {
							if (arr[drr][dcc] == 0) {
								cnt++;
							}
						}
					}

				}
			}

		}
		System.out.println(cnt);
	}

}


import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			System.out.println("#" + tc);
			
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			// 각 값을 입력해준다
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}

			int[][] arr_90 = new int[N][N];
			int[][] arr_180 = new int[N][N];
			int[][] arr_270 = new int[N][N];

			// 오른쪽으로 90도 돌리기
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--) {
					arr_90[j][N - 1 - i] = arr[i][j];
				}
			}

			// 오른쪽으로 180도 돌리기
			for (int j = N - 1; j >= 0; j--) {
				for (int i = N - 1; i >= 0; i--) {
					arr_180[N - 1 - j][N - 1 - i] = arr[j][i];

				}
			}

			// 오른쪽으로 270도 돌리기
			for (int i = N - 1; i >= 0; i--) {
				for (int j = 0; j < N; j++) {
					arr_270[N - 1 - i][j] = arr[j][i];

				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(arr_90[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr_180[i][j]);
				}
				System.out.print(" ");
				for (int j = 0; j < N; j++) {
					System.out.print(arr_270[i][j]);
				}
				System.out.println();
			}

		}

	}

}

package main;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;



public class Main_1012유기농배추 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// dx, dy 4방탐색 배열 만들기
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// queue 만들기
		Queue<int[]> queue = new ArrayDeque<>();

		// 테스트 케이스 T
		int T = sc.nextInt();
		// 배추밭의 가로길이
		int row = sc.nextInt();
		// 세로길이
		int column = sc.nextInt();
		
		
		// 배추밭을 생성하고 모두 0으로 채운다.
		int[][] arr = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int k = 0; k < column; k++) {
				arr[i][k] = 0;
			}
		}
		
		
		// 배추의 위치의 개수
		int bae = sc.nextInt();
	
			
		for (int i = 0; i < bae; i++) {
			// 배추의 위치를 입력받는다.
			int X = sc.nextInt();
			int Y = sc.nextInt();
			arr[X][Y] = 1;
			
			}
			
		
		
		
		
		// bfs 바르기
		// 배추흰나비라는데 그냥 벌레임.
	    int bug = 0;

		for (int x = 0; x < row; x++) {
			for (int y = 0; y < column; y++) {
				// 값을 돌면서 1 이면 bfs 출동
				// bfs 값을 돌면서 만나는 1 값들은 0으로 바꿔 카운트 방지

				if (arr[x][y] == 1) {
					bug++;
					arr[x][y] = 0;

					int[] array = new int[2];
					array[0] = x;
					array[1] = y;
					queue.offer(array);

					// queue에서 꺼낸 cx, cy에서 cx+dx, cy+dy 중 1을 만나면 0으로 바꾸고 queue에 해당 값 넣음 (queue가 빌
					// 때까지)
					while (!queue.isEmpty()) {
						array = queue.poll();
						int cx = array[0];
						int cy = array[1];
						// 4방탐색
						for (int i = 0; i < 4; i++) {
							if (cx + dx[i] < 0 || cy + dy[i] < 0 || cx + dx[i] >= row || cy + dy[i] >= column)
								continue;
							if (arr[cx + dx[i]][cy + dy[i]] == 1) {
								arr[cx + dx[i]][cy + dy[i]] = 0;

								// 새로 선언 안해주면 참조형이어서 다른 값들도 바뀜
								// 초기화 필수
								array = new int[2];
								array[0] = cx + dx[i];
								array[1] = cy + dy[i];
								queue.offer(array);
							}

						}
					}

				}
			}
		}
		
		System.out.print(bug);

	}
}

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 직사각형이 들어갈 공간
		int[][] arr = new int[N][N];
		// 바뀐 값들을 넣어줄 새로운 잉여 공간을 만들어준다.
		int[][] arr1 = new int[N][N];
		// 각 좌표에서 들어간 부분을 더해준다.
		for (int j = 0; j < N; j++) {
			for (int k = 0; k < N; k++) {
				arr[j][k] = sc.nextInt();

			}
		}

		// 각 좌표값을 넣어주는데 0인 부분의 공간을 확인한다.
		// bfs 사용
		// dx, dy 4방탐색 배열 만들기
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		int max = 0;
		// 비가 2부터 특정 값으로 돌아갈때 마다
		for (int rain = 0; rain < 100; rain++) {
			// 특정 값을 만날 때 마다 값을 바궈준다.
			// 이하인 값들을 0으로 잡아준다
			// 나머지 값을 1로 잡아준다.
			int cnt = 0;
			// 새로운 값을 리셋
			arr1 = new int[N][N];
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					if (arr[x][y] > rain) {
						arr1[x][y] = 1;
					}
				}
			}
		
			// queue 만들기
			Queue<int[]> queue = new ArrayDeque<>();

			// 특정 값보다 작은 값들을 만나면 그 값들을 모두 0 으로 바꿔주는데
			// 그렇지 않은 값들의 구역을 따로 구해줘여한다.
			cnt =0;
			for (int x = 0; x < N; x++) {
				for (int y = 0; y < N; y++) {
					// 0인 부분을 만났을 떄 1을 넣어준다.
					// 그리고 0을 만나면 카운트를 해준다.
					// 크기를 출력해줄 친구
					if (arr1[x][y] == 1) {
						cnt++;

						arr1[x][y] = 0;
						// 큐에 좌표를 하나씩 넣어준다.
						int[] array = new int[2];
						array[0] = x;
						array[1] = y;
						queue.offer(array);

						// queue에서 꺼낸 cx cy에서 탐색을하고 1을 만나면 0으로 바꾼다.
						while (!queue.isEmpty()) {
							array = queue.poll();
							int cx = array[0];
							int cy = array[1];
							// 4방
							for (int i = 0; i < 4; i++) {
								if (cx + dx[i] < 0 || cy + dy[i] < 0 || cx + dx[i] >= N || cy + dy[i] >= N)
									continue;
								if (arr1[cx + dx[i]][cy + dy[i]] == 1) {
									arr1[cx + dx[i]][cy + dy[i]] = 0;
									// 새로 선언 안해주면 참조여서 다른 값들도 변함
									// 초기화 해야한다.
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
			if(max <= cnt) {
				max = cnt;
			}
		}
		System.out.println(max);
	}
}
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_17141연구소2 {

	static int N, M, max, Zero, ans;
	static int[][] arr;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 연구소의 크기
		N = sc.nextInt();
		// 바이러스 갯수
		M = sc.nextInt();

		Zero = 0;
		arr = new int[N][N];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if (arr[i][j] == 0)
					Zero++;
			}
		}

		birus(0);
		System.out.println((ans == Integer.MAX_VALUE) ? -1 : ans);

	}

	// M개의 바이러스를 심는 경우
	static void birus(int idx) {
		if (idx == M) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 2;
					birus(idx + 1);
					arr[i][j] = 0;
				}
			}
		}
	}

	// bfs로 감싸기
	static void bfs() {
		int[][] dist =  new int[N][N];
		int zero = Zero-M;

		Queue<int[]> q = new LinkedList<>();
		// 바이러스 퍼뜨리기
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 2) {
					q.add(new int[] { i, j });
				}

			}
		}

		// 복사맵
		int[][] map = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				map[i][j] = arr[i][j];
			}
		}
		
		int time = 0;
		dist = new int[N][N];
		while (!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			// 값을 하나씩 줄여준다.
			for (int k = 0; k < 4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if (nx < 0 || ny < 0 || nx >= N || ny >= N)
					continue;
				// 0일 부분을 만난다.
				dist[nx][ny] = dist[x][y]+1;
				if (map[nx][ny] == 0) {
					time =  Math.max(time, dist[nx][ny]);
					zero--;
					map[nx][ny] = 2;
					q.add(new int[] { nx, ny });
					// 값확인
//					for (int c = 0; c < N; c++) {
//						System.out.println(Arrays.toString(dist[c]));
//					}
//					System.out.println("거리 :  "+time);
				}
			}
			// 0이 아님 값에 들어가지 않음으로 -1 출력
			if (zero == 0) {
				ans = Math.min(ans, time);
			}
		}
	}
}
import java.util.Scanner;

public class Main {

	static int N, M, cnt;
	static int[][] arr;
	// 북 동 남 서
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 방크기
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		// 값들은 1부터 N까지 입력을 해준다.

		// 로봇의 좌표
		int r = sc.nextInt();
		int c = sc.nextInt();
		// 방향
		int d = sc.nextInt();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

//		// 값 확인
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(arr[i][j]);
//			}
//			System.out.println();
//		}

		// 청소한 자리는 -1로 바꿔준다
		// 청소하지 않은 자리는 0. 벽은 1이다.
		cnt = 1;
		// dfs
		DFS(r, c, d);
		System.out.println(cnt);

	}

	static void DFS(int r, int c, int d) {

		arr[r][c] = -1;

		// 4방향을 체크한다.
		for (int i = 0; i < 4; i++) {
			// 원하는 방향으로 돌리긴 위해서
			d = (d + 3) % 4;
			// d 값에 넣고 원하는 방향으로 돌려준다.
			int nr = r + dy[d];
			int nc = c + dx[d];
			if (nr >= 0 && nc >= 0 && nr < N && nc < M && arr[nr][nc] == 0) {
				cnt++;
				DFS(nr, nc, d);
				return;
			}

		}
		// 네 방향이 청소 되어 있고 벽인 경우
		// 바라보는 방향을 유지하고 이동
		// 뒤 에 값은 2를 더한 값이 된다.
		int back = (d + 2) % 4;
		int by = r + dy[back];
		int bx = c + dx[back];
		// 뒤를 보는 데 청소가 안된 곳이 있으면 이동
		// 0인 구역을 이동한다. // 벽인 아닌 경우 이동을 한다.
		if (by >= 0 && bx >= 0 && by < N && bx < M && arr[by][bx] != 1) {
			DFS(by, bx, d);
		}

	}

}
import java.util.ArrayDeque;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		// 값을 저장해줄 친구
		int[][] arr = new int[N][N];
		// 값을 입력받는다
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		// bfs용 q
		ArrayDeque<int[]> q = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][N];

		// 델타베열
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		// 섬의 갯수 만큼 카운트를 해주고 갚을 체워줄 친구
		int cnt = 0;
		// 받아온 값들을 바탕으로 몇번쨰 섬인지를 값을 업데이트 해준다.
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {

				// 1이 들어간 값들을 넣어준다.
				if (arr[i][j] == 0)
					continue;
				// 방문한 경우
				if (visited[i][j])
					continue;

				q.offerLast(new int[] { i, j });
				cnt++;
				arr[i][j] = cnt;
				while (!q.isEmpty()) {
					int x = q.peekFirst()[0];
					int y = q.pollFirst()[1];

					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];
						if (nx < 0 || ny < 0 || nx >= N || ny >= N)
							continue;
						// 바다인 경우 큐에 넣을 필요없다
						if (arr[nx][ny] == 0)
							continue;
						if (visited[nx][ny])
							continue;

						// 방문체크
						visited[nx][ny] = true;

						// 범위 안에 있는 값들을 돌려준다.
						arr[nx][ny] = cnt;
						q.offerLast(new int[] { nx, ny });

					}

				}
			}
		}

		// bfs를 돌리며, 특정 값이 나올때 마다 돌려준다.

		// 최소 거리를 저장할 것
		int dist = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0)
					continue;
				// 시작점을 찾았다.
				ArrayDeque<int[]> q2 = new ArrayDeque<>();
				q2.add(new int[] { i, j });

				// 방문철2
				boolean[][] visited2 = new boolean[N][N];

				// 거리를 저장할 친구가
				int[][] dist_map = new int[N][N];

				// 시작한 섬이 어떤 섬인지
				cnt = arr[i][j];

				while (!q2.isEmpty()) {
					int x = q2.peekFirst()[0];
					int y = q2.pollFirst()[1];
					for (int k = 0; k < 4; k++) {
						int nx = x + dx[k];
						int ny = y + dy[k];

						if (nx < 0 || ny < 0 || nx >= N || ny >= N)
							continue;
						// 바다가 아니면 패스
						if (arr[nx][ny] != 0)
							continue;
						if (visited2[nx][ny])
							continue;
						// 방문처리
						visited2[nx][ny] = true;
						dist_map[nx][ny] = dist_map[x][y] + 1;

						q2.add(new int[] { nx, ny });

					}
				}
				// 각 경우마다 값이 들어갔고
				// 최소 거리를 찾아 줘야한다.
				for (int i2 = 0; i2 < N; i2++) {
					for (int j2 = 0; j2 < N; j2++) {
						//모든 값을 돌면서 만나야하는 섬보다 작은 경우 넘어간다
						if (arr[i2][j2] <= cnt)
							continue;
						// 만나야하는 값을 만나면 멈춰서  값을 확인한다.
						for (int k = 0; k < 4; k++) {
							int nx = i2 + dx[k];
							int ny = j2 + dy[k];
							if (nx < 0 || ny < 0 || nx >= N || ny >= N)
								continue;
							// 멈춰야 하는 값에서 거리를 보고 극 값에서 최소값을 구한다.
							int mdist = dist_map[nx][ny];
							if (mdist == 0)
								continue;
							//작은 값 업데이트
							if (dist > mdist)
								dist = mdist;
							if (dist == 1)
								break;
						}

					}
				}

			}
		}
		System.out.println(dist);

	}

}
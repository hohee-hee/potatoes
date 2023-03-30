import java.util.Scanner;

public class Main {

	static int[] dx = new int[] { -1, 1, 0, 0 };
	static int[] dy = new int[] { 0, 0, -1, 1 };
	static int N, M;
	static int[][] arr, visit, melt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		
		//arr에 값을 다 담아준다
		// 배열melt에 녹는 빙산의 높이들을 다 넣어주었다.
		// 빙산의 개수는 1개임으로 0개인 경우
		// 2개 이상인 경우 값을 출력했고
		// 그렇지 않으면 한번더 녹인다.
		
		arr = new int[N][M];
		visit = new int[N][M];
		melt = new int[N][M];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		solution();
	}

	// 답을 확인할 공간
	public static void solution() {
		int year = 0;
		while (true) {
			// dfs로 빙산 카운트
			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					//방문하지 않앗으면
					if (visit[i][j] == 0 && arr[i][j] != 0) {
						dfs(i, j);
						cnt++;
					}

				}
			}
			if (cnt == 0) {
				System.out.println(0);
				break;
			} else if (cnt >= 2) {
				System.out.println(year);
				break;
			}
			melt();
			year++;

		}

	}

	private static void dfs(int x, int y) {
		// 방문 체크
		visit[x][y] = 1;

		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
				// 1년 후 녹는 빙산의 양
				if (arr[nx][ny] == 0)
					melt[x][y]++;
				// dfs 재귀 // 방문하지 않은 곳이 있으면 
				if (visit[nx][ny] == 0 && arr[nx][ny] != 0)
					dfs(nx, ny);
			}
		}

	}

	private static void melt() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] -= melt[i][j];
				// 0보다 작으면 0으로 바꿔주기
				if(arr[i][j]< 0 )
					arr[i][j] = 0;
				// 방문한 곳과 녹는 값을 초기화 시켜준다.
				// 새로운 arr 가 탄생
				visit[i][j] = 0;
				melt[i][j] = 0;
			}
		}

	}

}
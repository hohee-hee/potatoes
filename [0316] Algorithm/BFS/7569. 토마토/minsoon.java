import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 삼차원 배열을 사용한다.
		int[] dx = { -1, 0, 1, 0, 0, 0 };
		int[] dy = { 0, 1, 0, -1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, 1, -1 };
		
		//가세 높
		int X = sc.nextInt();
		int Y = sc.nextInt();
		int Z = sc.nextInt();

		int[][][] tomato = new int[Z][X][Y];
		int cnt = 0, days = 0;
		Queue<int[]> que = new LinkedList<>();

		for (int z = 0; z < Z; z++)
			for (int y = 0; y < Y; y++) {
				for(int x=0; x<X; x++) {
				tomato[z][x][y] = sc.nextInt();
				// 토마토가 1인경우
				if (tomato[z][x][y] == 1)
					que.add(new int[] {z, x, y });
				// 0인경우 카운트를 해주고
				else if (tomato[z][x][y] == 0)
					cnt++;
				else if(tomato[z][x][y] != -1 && tomato[z][x][y] == 0) {
					cnt = 0;
				}
			}}

		// 카운트가 0이 될때 까지 돌려준다.
		while (cnt > 0 && !que.isEmpty()) {

			// 큐가 빠질때 까지 돌려준다.
			for (int s = que.size(); s > 0; s--) {
				int[] cur = que.poll();

				for (int k = 0; k < 6; k++) {
					int nz = cur[0] + dz[k];
					int nx = cur[1] + dx[k];
					int ny = cur[2] + dy[k];

					if (ny < 0 || nx < 0 ||nz < 0 || nx >= X || ny >= Y || nz >= Z || tomato[nz][nx][ny] != 0)
						continue;
					// 카운트를 해주고 새로운 값을 큐에 넣어준다.
					// 주변의 토마토를 1로 만들어준다.
					cnt--;
					tomato[nz][nx][ny] = 1;
					que.add(new int[] { nz, nx, ny });
				}
			}
			days++;
		}
		System.out.println(cnt == 0 ? days : -1);

	}
}
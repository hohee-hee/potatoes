import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		// 직사각형이 들어갈 공간
		int[][] arr = new int[N][N];

			// 각 좌표에서 들어간 부분을 더해준다.
			for (int j = 0; j < N; j++) {
				String str = sc.next();
				for (int k = 0; k <N; k++) {
					arr[j][k] = str.charAt(k)-'0';

				}
			}
		
	
		// 각 좌표값을 넣어주는데 0인 부분의 공간을 확인한다.
		// bfs 사용
		// dx, dy 4방탐색 배열 만들기
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };

		
		// queue 만들기
		Queue<int[]> queue = new ArrayDeque<>();
		
		//영역을 넣어준다.
		ArrayList<Integer> arry = new ArrayList<>();

		// x, y가 1인 지점을 만나면 0으로 바꾸고 queue에 x, y를 넣음
		// -> number +1 ; count는 0으로 바꿀때마다 ++;
		for (int x = 0; x < N; x++) {
			for (int y = 0; y < N; y++) {
				//0인 부분을 만났을 떄 1을 넣어준다.
				// 그리고 0을 만나면 카운트를 해준다.
				int cnt =0;

				// 크기를 출력해줄 친구
				if (arr[x][y] == 1) {
					arr[x][y] = 0;
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
							if (arr[cx + dx[i]][cy + dy[i]] == 1) {
								arr[cx + dx[i]][cy + dy[i]] = 0;

								cnt++;
								// 새로 선언 안해주면 참조여서 다른 값들도 변함
								// 초기화 해야한다.
								array = new int[2];
								array[0] = cx + dx[i];
								array[1] = cy + dy[i];

								queue.offer(array);

							}
						}

					}
					arry.add(cnt+1);
		
				}
			}
		}
		System.out.println(arry.size());
        Collections.sort(arry); // 오름차순 정렬
		for(int i: arry) {
			System.out.println(i+ " ");
		}
	}
}
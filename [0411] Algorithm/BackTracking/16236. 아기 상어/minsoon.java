package day0407;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_16236아기상어 {
	// 일단 보류
	static int[] dx = { -1, 0, 0, 1 };
	static int[] dy = { 0, -1, 1, 0 };

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		// 물고기의 위칠 저장
		int[][] arr = new int[N][N];
		
		// 물고기 크기 별로 저장// 1 to 6 // 상어를 저장하는 9 도 있기에
		int[] fish = new int[10];

		// 상어의 위치 저장
		int Sr = 0;
		int Sc = 0;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				int num = sc.nextInt();
				arr[i][j] = num;
				fish[num]++;
				if (num == 9) {
					Sr = i;
					Sc = j;
				}

			}
		}
		// 움직인 거리
		int move = 0;
		// 상어의 크기, 상어의 위치 저장
		int size = 2;
		// 물고기 먹은 수.
		int eat = 0;

		// 지금 사이즈에 잡을 수 있는 물고기들을 모아놨다.
		int fish_sum = 0;
		
		for (int i = 1; i < size; i++) {
			fish_sum += fish[i];
		}

		int[][] dist = new int[N][N];
		// 물고기를 잡아주는 공간이다.
		// 잡아야 할 물고기가 0이 아닌 경우
		arr[Sr][Sc] = 0;
		while (fish_sum != 0) {
			dist = new int[N][N];
			
			Queue<int[]> q = new LinkedList<>();
			// 가장 가까운 물고기를 탐색해야한다.
			// 사이즈보다 같거나 같은 곳을 이동 할 수 있다.
			q.add(new int[] { Sr, Sc });
			loop:
			while (!q.isEmpty()) {
				
				int x = q.peek()[0];
				int y = q.poll()[1];
				
				for (int i = 0; i < 4; i++) {
					int nx = x + dx[i];
					int ny = y + dy[i];

					if (nx < 0 || ny < 0 || nx >= N || ny >= N)
						continue;
					// 자기 사이즈 보다 큰 경우 벽이라고 본다.
					if (arr[nx][ny] > size)
						continue;
					dist[nx][ny] = dist[x][y] +1;
					// 한칸 움직일때 마다 값을 추가한다.
					// 빈칸이 아닌 경우 즉 물고기를 만나는 경우, 가장 가까운 물고기를 만났을 때다.
					// 경우를 정해야 하기에 위에서 부터 값을 돌려야한다.
					// 먹기위한 들어감
					if (arr[nx][ny] != 0 && arr[nx][ny] < size ) {
						// 그 자리에 있는 물고리 줄이기,물고기를 만나면 그 자리를 0으로 만들어주고
						fish[arr[nx][ny]]--;
						arr[nx][ny] = 0;
						// 상어의 위치 업데이트
						Sr = nx;
						Sc = ny;
						// 먹은 갯수 추가
						eat++;
						// 상어의 크기와 먹은 갯수가 같으면 먹은 갯수 초기화하고 사이즈 증가
						if (size == eat) {
							size++;
							System.out.println("크기 : " + size);
							eat = 0;
						}
						System.out.println("거리" + dist[nx][ny]);
						move += dist[nx][ny];
						// 거리를 저장하고, 그 거리보다 작은 경우를 모두 확인하고
						
						for(int i1 =0; i1<N; i1++) {
							System.out.println(Arrays.toString(arr[i1]));
						}
						
						break loop;
					}
					// 일단 먹지 말고 같은 거리인 애들을 모두 넣어주고 
					// sort를 시켜 특정 값들을 넣어주면 된다. 
					
					// 0이 아닌 부분을 만나면 q에 넣어주고 돌린다.
					q.add(new int[] { nx, ny });
				}
			}
			// 물고기 몇마리 인지 확인
			fish_sum =0;
			for (int i = 1; i < size; i++) {
				fish_sum += fish[i];
			} 
			
			System.out.println(Arrays.toString(fish));
			System.out.println("남은 물고기" + fish_sum);
			if(fish_sum == 0) break;
		}
		System.out.println(move);
	}
}
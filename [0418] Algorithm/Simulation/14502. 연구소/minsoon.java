import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

	static int N, M, max;
	static int[][] arr;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		max = Integer.MIN_VALUE;
		
		arr = new int[N][M];

		// 세웠던 벽을 체크할 방문

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		wall(0);
		System.out.println(max);

		// 1벽, 2 바이러스
		// 바이러스가 퍼지지 않는 안전구역의 댓값
		// 지도의 크기가 크지 않기에 그대로 구현
		// 벽을 박는 모든 경우를 만들어준다.

	}

	// 벽 3개를 심는 경우
	static void wall(int idx) {
		// 벽을 3개 세우는 경우 계산 시작
		if (idx == 3) {
			bfs();
			return;
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (arr[i][j] == 0) {
					arr[i][j] = 1;
					wall(idx + 1);
					arr[i][j] = 0;
				}
			}
		}
	}

	// bfs로 2개인 경우 다 감싸기
	static void bfs() {
				
		Queue<int[]> q = new LinkedList<>();
		// 바이러스 퍼뜨리기
		for(int i =0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] == 2) {
					q.add(new int[] {i,j});
				}
				
			}
		}
		
		// 복사맵
		int[][] map =  new int[N][M];
		for(int i =0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				map[i][j] =  arr[i][j];
			}
		}
		// 기둥이 3개씩 잘 박힘
		
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			for(int k=0; k<4; k++) {
				int nx = x + dx[k];
				int ny = y + dy[k];
				if(nx <0 || ny <0 || nx >=N || ny>=M) continue;
				if(map[nx][ny] == 0) {
					q.add(new int[] {nx, ny});
					map[nx][ny] =2;
				}
			}
      }
		
//		//값 확인
//		for(int c=0; c<N; c++) {
//			System.out.println(Arrays.toString(map[c]));
//		}
//		System.out.println("============================"); 
		
		
		// 나머지 0인 부분 카운트
		int cnt = 0;
		for(int i1 =0; i1<N; i1++) {
			for(int j1 = 0; j1<M; j1++) {
				if(map[i1][j1]== 0) {
					cnt++;
				}
				max = Math.max(max, cnt);
			}
		}
		
		

	}


}
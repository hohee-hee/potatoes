import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) arr[y][x] = sc.nextInt();
		}

		boolean[][] chk = new boolean[N][N];
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		Queue<int[]> q1 = new ArrayDeque<>();
		Queue<int[]> q2 = new ArrayDeque<>();
		int min = Integer.MAX_VALUE;
		
		// 섬 하나 다 찾기 -> 땅끝마을에서 bfs -> 그다음 섬으로 이동 후 반복
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(!chk[y][x] && arr[y][x] == 1) { // 섬 하나 발견
					int[][] sea = new int[N][N];
					
					chk[y][x] = true;
					q1.add(new int[] {x, y});
					while(!q1.isEmpty()) {
						int xx = q1.peek()[0];
						int yy = q1.poll()[1];
						for(int i=0; i<4; i++) {
							int cx = xx + dx[i];
							int cy = yy + dy[i];
							if(cx < 0 || cy < 0 || cx >= N || cy >= N) continue;
							
							if(!chk[cy][cx] && arr[cy][cx] == 1) { // 땅인 경우
								chk[cy][cx] = true; 
								q1.add(new int[] {cx, cy});
							} else if(!chk[cy][cx] && arr[cy][cx] == 0) { // 해변인 경우
								chk[cy][cx] = true; 
								sea[cy][cx] = 1;
								q2.add(new int[] {cx, cy});
							}
						}	
					} // 섬 하나 탐색 끝
					
					out : 
					while(!q2.isEmpty()) { // 다른 섬으로 가는 길 탐색
						int xx = q2.peek()[0];
						int yy = q2.poll()[1];
						if(sea[yy][xx] >= min) { // 가지치기. min 값 넘으면 끝냄
							q2.clear();
							break out;
						}
						
						for(int i=0; i<4; i++) {
							int cx = xx + dx[i];
							int cy = yy + dy[i];
							if(cx < 0 || cy < 0 || cx >= N || cy >= N) continue;
							
							if(!chk[cy][cx] && arr[cy][cx] == 1) { // 안가본 섬 발견
								if(min > sea[yy][xx]) { 
									min = sea[yy][xx]; 
									q2.clear();
									break out;
								}
							} else if(sea[cy][cx] == 0 && arr[cy][cx] == 0) { // 바다탐험
								sea[cy][cx] = sea[yy][xx] + 1; 
								q2.add(new int[] {cx, cy});
							}
						}
					}
					
				} // 섬 하나, 그 섬부터 다른 섬 탐색 종료
			}
		}
		
		System.out.println(min);
	}
}

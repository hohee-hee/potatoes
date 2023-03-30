import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		arr = new int[N][M]; 
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 여기부터
		int years = 0;
		while(true) {
			int num = bfs();
			if(num == 0) { System.out.println(0); break; } 
			else if(num > 1) { System.out.println(years); break; } 
			years++;
		}
		
	}
	
	static int bfs() {
		Queue<int[]> q = new LinkedList<>();
		boolean[][] chk = new boolean[N][M];
		int[] dx = { -1, 1, 0, 0 }; 
		int[] dy = { 0, 0, -1, 1 }; 
		int num = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(arr[i][j] > 0 && !chk[i][j]) {
					num++;
					if(num > 1) return num;
					q.offer(new int[] {j, i});
					while(!q.isEmpty()) {
						int x = q.peek()[0];
						int y = q.poll()[1];
						chk[y][x] = true;
						
						for(int a=0; a<4; a++) {
							int cx = x + dx[a];
							int cy = y + dy[a];
							if(cx < 0 || cy < 0 || cx >= M || cy >= N || chk[cy][cx]) continue;
							
							// 바다면 -1
							if(arr[cy][cx] == 0 && arr[y][x] > 0) arr[y][x]--;
							else if(arr[cy][cx] > 0) {
								chk[cy][cx] = true;
								q.offer(new int[] {cx, cy});
							}
						}
					}
				}
			}
		}
		return num;
	}
}
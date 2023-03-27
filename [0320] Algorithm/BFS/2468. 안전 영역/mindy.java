import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		
		int maxH = 0, minH = 100;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) { 
				arr[i][j] = sc.nextInt();
				if(maxH < arr[i][j]) maxH = arr[i][j];
				if(minH > arr[i][j]) minH = arr[i][j];
			}
		}
		
		int max = 1;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		
		for(int h=minH; h<=maxH; h++) {
			boolean[][] chk = new boolean[N][N];
			int cnt = 0;
			Queue<int[]> q = new ArrayDeque<>();
			for(int y=0; y<N; y++) {
				for(int x=0; x<N; x++) {
					if(!chk[y][x] && arr[y][x] > h) { // 한덩이 발견
						cnt++;
						chk[y][x] = true;
						int[] tmp = { x, y };
						q.offer(tmp);
						while(!q.isEmpty()) { // 그 한덩이 처리
							int cx = q.peek()[0];
							int cy = q.poll()[1];
							for(int i=0; i<4; i++) {
								int nx = cx + dx[i];
								int ny = cy + dy[i];
								if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
								
								if(!chk[ny][nx] && arr[ny][nx] > h) {
									chk[ny][nx] = true;
									int[] ttmp = new int[2];
									ttmp[0] = nx;
									ttmp[1] = ny;
									q.offer(ttmp);
								}
							}
						}
					}
				}
			}
			if(max < cnt) max = cnt;
		} 
		System.out.println(max);
	}
}


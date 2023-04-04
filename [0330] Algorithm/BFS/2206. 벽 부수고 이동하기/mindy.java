import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt(); sc.nextLine();
		int[][] arr = new int[N+1][M+1];
		for(int y=1; y<=N; y++) {
			String tmp = sc.nextLine();
			for(int x=1; x<=M; x++) arr[y][x] = Integer.parseInt(tmp.substring(x-1, x));
		}
		
		///// 여기부터
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int[][] be = new int[N+1][M+1];
		int[][] af = new int[N+1][M+1];
		Queue<int[]> q = new LinkedList<>();
		
		be[1][1] = 1;
		q.offer(new int[] {1, 1, 0, 1}); // x, y, 벽깸?, leng
		while(!q.isEmpty()) { // 안깼을때 bfs 루프
			int x = q.peek()[0];
			int y = q.peek()[1];
			int cra = q.peek()[2];
			int leng = q.poll()[3];
			
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				if(cx < 1 || cy < 1 || cx > M || cy > N) continue;
				
				// 0인 경우, 안깨도 되는 경우
				if(arr[cy][cx] == 0) {
					if(cra == 0 && be[cy][cx] == 0) {
						be[cy][cx] = leng + 1;
						q.offer(new int[] {cx, cy, cra, leng+1}); 
					} else if(cra == 1 && af[cy][cx] == 0) {
						af[cy][cx] = leng + 1;
						q.offer(new int[] {cx, cy, cra, leng+1});	
					}
				}
				// 벽인 경우
				else if(arr[cy][cx] == 1 && cra == 0 && af[cy][cx] == 0) { // 깰 수 있음
					af[cy][cx] = leng + 1;
					q.offer(new int[] {cx, cy, 1, leng+1});
				} // 이미 깬 경우 -> 암것도 안함
			}
		}
		
		// 출력
		if(be[N][M] == 0 && af[N][M] == 0) System.out.println(-1);
		else if(be[N][M] == 0 || af[N][M] == 0) System.out.println(Math.max(be[N][M], af[N][M]));
		else System.out.println(Math.min(be[N][M], af[N][M]));
	}
}
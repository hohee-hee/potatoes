import java.util.Scanner;

public class Main {
	static int N, M, cnt=0;
	static int[][] arr;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		M = sc.nextInt();
		int ny = sc.nextInt();
		int nx = sc.nextInt();
		int di = sc.nextInt(); 
		arr = new int[N][M];
		chk = new boolean[N][M];
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) arr[y][x] = sc.nextInt();
		}
		
		// 청소루프
		while(true) {
			if(!chk[ny][nx]) {
				chk[ny][nx] = true;// 현재 칸 청소
				cnt++;
			}
			
			boolean v = true;
			for(int d=0; d<4; d++) { // 4칸 중 하나라도 안치운 칸 있나?
				if(!chk[ny+dy[d]][nx+dx[d]]
						&& arr[ny+dy[d]][nx+dx[d]] == 0) 
					v = false; 
			}
			
			if(v) { // 현재 주변 4칸 이미 다 방문
				// 1칸 후진 가능 => 후진 후 처음으로
				if(arr[ny-dy[di]][nx-dx[di]] == 0) { 
					nx -= dx[di];
					ny -= dy[di];
					continue; 
				}
				else break; // 불가 => break; 
				
			} else { // 청소할 곳 있음
				// 왼쪽으로 회전 => 청소할 쪽 방면일때까지 => 1칸 전진 후 처음으로
				di = rotate(di);
				while(chk[ny+dy[di]][nx+dx[di]] 
						|| arr[ny+dy[di]][nx+dx[di]] == 1) di = rotate(di);
				nx += dx[di];
				ny += dy[di];
				continue;
			}
		}
		System.out.println(cnt);		
	}
	
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int rotate(int di) {
		return (di+3)%4; 
	}
}

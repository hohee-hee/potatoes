import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int sero, garo, cnt, che;
	static int[][] arr; 
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sero = sc.nextInt();
		garo = sc.nextInt();
		arr = new int[sero][garo];
		for(int i=0; i<sero; i++) {
			for(int j=0; j<garo; j++) arr[i][j] = sc.nextInt(); 
		}
		
		////// 
		cnt = -1; che = 0;
		int tmp = -1;
		while(tmp != 0) {
			tmp = bfs(0,0);
			if(tmp != 0) che = tmp;
			cnt++;
		}
		System.out.println(cnt);
		System.out.println(che);
	}
	static int bfs(int x, int y) {
		boolean chk[][] = new boolean[sero][garo];
		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] {x, y});
		int chee = 0;
		
		while(!q.isEmpty()) {
			int xx = q.peek()[0];
			int yy = q.poll()[1];
			for(int d=0; d<4; d++) {
				int nx = xx + dx[d];
				int ny = yy + dy[d];
				if(nx < 0 || ny < 0 || nx >= garo || ny >= sero
						|| chk[ny][nx]) continue;
				
				chk[ny][nx] = true;
				if(arr[ny][nx] == 1) {
					arr[ny][nx] = 0;
					chee++;
					continue;
				}
				q.add(new int[] {nx, ny});
			}
		}
		
		return chee;
	}
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };	
}
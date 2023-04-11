import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int K = sc.nextInt();
		int W = sc.nextInt(), H = sc.nextInt();
		int[][][] arr = new int[K+1][H][W];
		int[][] map = new int[H][W];
		for(int y=0; y<H; y++) {
			for(int x=0; x<W; x++) map[y][x] = sc.nextInt();
		}
		if(W == 1 && H == 1) { System.out.println(0); return; }
		
		Queue<Pos> q = new ArrayDeque<>();
		q.add(new Pos(0, 0, 0, 0));
		int tmp = -1;
		out:
		while(!q.isEmpty()) {
			Pos p = q.poll();
			
			for(int i=0; i<4; i++) { // 원숭
				int nx = p.x + mx[i];
				int ny = p.y + my[i];
				if(nx < 0 || ny < 0 || nx >= W || ny >= H
						|| arr[p.j][ny][nx] != 0
						|| map[ny][nx] == 1) continue;
				arr[p.j][ny][nx] = p.dis+1; 
				if(nx == W-1 && ny == H-1) { tmp = p.dis+1; break out; }
				q.add(new Pos(nx, ny, p.j, p.dis+1));
			}
			
			if(p.j < K) { // 점프 가능?
				for(int i=0; i<8; i++) { // 말
					int nx = p.x + hx[i];
					int ny = p.y + hy[i];
					if(nx < 0 || ny < 0 || nx >= W || ny >= H
							|| arr[p.j+1][ny][nx] != 0
							|| map[ny][nx] == 1) continue;
					arr[p.j+1][ny][nx] = p.dis+1; 
					if(nx == W-1 && ny == H-1) { tmp = p.dis+1; break out; }
					q.add(new Pos(nx, ny, p.j+1, p.dis+1));
				}
			}
		}
		System.out.println(tmp);
	}
	
	static int[] mx = { -1, 1, 0, 0 };
	static int[] my = { 0, 0, -1, 1 };
	static int[] hx = { 1, 2, 2, 1, -1, -2, -2, -1 };
	static int[] hy = { -2, -1, 1, 2, -2, -1, 1, 2 };
	
	static class Pos{
		int x, y, j, dis;
		public Pos(int x, int y, int j, int dis) {
			this.x = x;
			this.y = y;
			this.j = j;
			this.dis = dis;
		}
	}
}
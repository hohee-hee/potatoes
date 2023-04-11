import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N];
		Shark srk = new Shark();
		srk.size = 2; srk.eat = 0; srk.mv = 0;
		int fish = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 9) { srk.x = j; srk.y = i; arr[i][j] = 0; }
				else if(1 <= arr[i][j] && arr[i][j] <= 6) fish++;
			}
		}
		
		while(fish-->0) { 
			int[] hubo = new int[3]; // x, y, dis
			Arrays.fill(hubo, Integer.MAX_VALUE);
			Queue<Position> q = new ArrayDeque<>(); 
			q.add(new Position(srk.x, srk.y, 1));
			boolean[][] chk = new boolean[N][N];
			int tmp = Integer.MAX_VALUE; 
			loop: 
			while(true) { // bfs 루프
				if(q.isEmpty())  break loop; 
				
				Position p = q.poll();
				for(int d=0; d<4; d++) {
					Position np = new Position(p.x+dx[d], p.y+dy[d], p.dis);
					if(np.x < 0 || np.x >= N || np.y < 0 || np.y >= N
							|| chk[np.y][np.x]) continue;
					chk[np.y][np.x] = true;
					if(arr[np.y][np.x] > srk.size) continue;
					q.add(new Position(np.x, np.y, np.dis+1));
					
					if(tmp < np.dis) break loop;
					if(1 <= arr[np.y][np.x] && arr[np.y][np.x] <= 6 
							&& arr[np.y][np.x] < srk.size) {
						tmp = np.dis;
						
						if(np.y < hubo[1] || np.y == hubo[1] && np.x < hubo[0]) {
							hubo[0] = np.x;
							hubo[1] = np.y;
							hubo[2] = np.dis;
						}
					}
				}
			}
			
			if(hubo[0] != Integer.MAX_VALUE) {
				arr[hubo[1]][hubo[0]] = 0;
				srk.x = hubo[0];
				srk.y = hubo[1];
				srk.eat++;
				srk.mv += hubo[2];
				if(srk.eat == srk.size) { srk.eat = 0; srk.size++; }
			}
		}
		System.out.println(srk.mv);
	}
	
	static int[] dx = { 0, -1, 1, 0 };
	static int[] dy = { -1, 0, 0, 1 };
	static class Shark {
		int x, y, size, eat, mv;
	}
	static class Position{
		int x, y, dis;
		Position(int x, int y, int dis){
			this.x = x;
			this.y = y;
			this.dis = dis;
		}
	}
}
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int H = sc.nextInt();
		int[][][] arr = new int[M][N][H];
		Queue<int[]> q = new ArrayDeque<>();
		
		// 값 넣는 김에 익은 토마토 큐에 저장
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					arr[m][n][h] = sc.nextInt();
					if(arr[m][n][h] == 1) {
						int[] tmp = new int[3];
						tmp[0] = m; tmp[1] = n; tmp[2] = h;
						q.offer(tmp);
					}
				}
			}
		}
		
		int[] dx = { -1, 1, 0, 0, 0, 0 };
		int[] dy = { 0, 0, -1, 1, 0, 0 };
		int[] dz = { 0, 0, 0, 0, -1, 1 };
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int z = q.poll()[2];
			for(int i=0; i<6; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				int cz = z + dz[i];
				
				if(0 <= cx && 0 <= cy && 0 <= cz 
						&& cx < M && cy < N && cz < H
						&& arr[cx][cy][cz] == 0) {
					int[] tmp = new int[3];
					tmp[0] = cx; tmp[1] = cy; tmp[2] = cz;
					q.offer(tmp);
					arr[cx][cy][cz] = arr[x][y][z] + 1;
				}
			}
		}
		
		int chk = -1;
		for(int h=0; h<H; h++) {
			for(int n=0; n<N; n++) {
				for(int m=0; m<M; m++) {
					chk = Math.max(chk, arr[m][n][h]);
					if(arr[m][n][h] == 0) { System.out.println(-1); return; }
				}
			}
		}
		if(chk == 1) { System.out.println(0); return; }
		System.out.println(chk-1);
	}
}
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int M = sc.nextInt();
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[M][N];
		
		while(K-- > 0) { // 직사각형 들
			int lb_x = sc.nextInt(), lb_y = sc.nextInt();
			int rt_x = sc.nextInt(), rt_y = sc.nextInt();
			for(int x=lb_x; x<rt_x; x++) {
				for(int y=lb_y; y<rt_y; y++) arr[y][x] = 1;
			}
		}
		
		int cnt = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Queue<int[]> q = new ArrayDeque<>();
		for(int y=0; y<M; y++) {
			for(int x=0; x<N; x++) {
				if(arr[y][x] == 0) { // 한덩이 발견
					cnt++;
					int size = 1;
					
					arr[y][x] = 1;
					int[] tmp = { x, y };
					q.offer(tmp);
					while(!q.isEmpty()) { // 그 한덩이 처리
						int cx = q.peek()[0];
						int cy = q.poll()[1];
						for(int i=0; i<4; i++) {
							int nx = cx + dx[i];
							int ny = cy + dy[i];
							if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
							
							if(arr[ny][nx] == 0) {
								arr[ny][nx] = 1;
								size++;
								int[] ttmp = new int[2];
								ttmp[0] = nx;
								ttmp[1] = ny;
								q.offer(ttmp);
							}
						}
					}
					pq.offer(size);
				}
			}
		}
		System.out.println(cnt);
		while(!pq.isEmpty()) System.out.print(pq.poll()+" ");
		System.out.println();
	}
}


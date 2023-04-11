import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N,M,cheese, cnt, time;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		arr =  new int[N][M];
		for(int i =0; i<N; i++) {
			for(int j = 0; j<M; j++) {
				int num = sc.nextInt();
				arr[i][j] = num;
				if(num == 1) cheese++;
			}
		}
		
		while(cheese!=0) {
			time++;
			// 이전 치즈
			cnt = cheese;
			melt();
		}
		System.out.println(time);
		System.out.println(cnt);
		
		
	}
	
	static void melt() {
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] {0,0});
		visited = new boolean[N][M];
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.poll()[1];
			for(int i =0; i<4; i++) {
				int nx = x + dx[i];
				int ny = y + dy[i];
				if(nx<0 || ny<0 || nx >=N || ny >= M || visited[nx][ny])continue;
				if(arr[nx][ny] == 1) {
					// 치즈 갯수 줄이기
					cheese--;
					arr[nx][ny] = 0;
				}
				else if(arr[nx][ny] == 0 ) {
					q.offer(new int[] {nx, ny});
				}
				visited[nx][ny] = true;
			}
		}
//		for(int i =0; i<N; i++) {
//			System.out.println(Arrays.toString(arr[i]));
//		}
//		System.out.println("_-------------------------");
	}

}
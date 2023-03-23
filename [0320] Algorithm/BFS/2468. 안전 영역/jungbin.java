package hw;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2468_안전 {
	static int n;
	static int[][] map;
	static boolean[][] ch;
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0,- 1, 0, 1};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		//지역 넓이
		n = sc.nextInt();
		//배열
		map = new int[n][n];
		//높이
		int max_h=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] > max_h) {
					max_h =map[i][j];
				}
			}
		}
		//안전 영역
		int max_a=0;

		for(int h=0; h<max_h+1; h++) {
			//확인 배열
			ch = new boolean[n][n];
			int cnt=0;
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(!ch[i][j] && map[i][j] > h){
						//조건 만족할 때 탐색
						cnt+=bfs(i,j,h); 
					}
					
				}
			}
			max_a = Math.max(max_a, cnt);
		}
		System.out.println(max_a);
	}
	static int bfs(int x, int y, int h) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{x,y});
		ch[x][y] = true;
		
		while(!q.isEmpty()) {
			int[] pos = q.poll();
			int px = pos[0];
			int py = pos[1];
			
			for(int i=0; i<4; i++) {
				int nx = px +dx[i];
				int ny = py +dy[i];
				
				if(nx<0 || ny<0 || nx>n-1 || ny >n-1) continue;
				if(ch[nx][ny]) continue;
				if(map[nx][ny]> h) {
					ch[nx][ny] = true;
					q.add(new int[] {nx,ny});
				}
			}
		}
		return 1;
	}
}

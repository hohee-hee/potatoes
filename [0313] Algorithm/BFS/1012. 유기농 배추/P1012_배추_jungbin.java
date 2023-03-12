package hw;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class P1012_배추 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//test case 반복
		int t = sc.nextInt();
		for(int tc=0; tc<t; tc++) {
			//배추밭 세로 길이 n
			int n=sc.nextInt();
			//가로 길이 m
			int m = sc.nextInt();
			
			//배추 배열
			int[][] map = new int[n][m];
			//배추 수 반복
			int k =sc.nextInt();
			for(int kc=0; kc<k; kc++) {
				map[sc.nextInt()][sc.nextInt()]=1;
			}
			
			//지렁이 수
			int cnt=0;
			
			//델타
			int[] dx = {0, -1, 0, 1};
			int[] dy = {-1, 0, 1, 0};
			
			//탐색 저장할 큐
			Queue<int[]> q = new ArrayDeque<>();
			
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					//배추가 있으면
					if(map[i][j]==1) {
						//자신 표시
						cnt++;
						map[i][j]=0;
						
						//자기 좌표 기억
						int[] array = new int[2];
						array[0]=i;
						array[1]=j;
						q.offer(array);
						
						while(!q.isEmpty()) {
							int[]arr = q.poll();
							int nx = arr[0];
							int ny = arr[1];
							
							//탐색
							for(int a=0; a<4; a++) {
								int x = nx+dx[a];
								int y = ny+dy[a];
								//범위 조건 제외
								if(x<0 || y<0 || x>=n || y>=m) continue;
								if(map[x][y]==1) {
									map[x][y]=0;
									int[] array1 = new int[2];
									array1[0]=x;
									array1[1]=y;
									q.offer(array1);
								}
								
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}

}

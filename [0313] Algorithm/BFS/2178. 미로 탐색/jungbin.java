//ㅎㅎㅎ형변환 미안 다음에 고쳐봄....

package day0315;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class P2178_미로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//목표 좌표 n,m
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		//미로 배열
		int[][] map  = new int[n][m];
		
		for(int i=0; i<n; i++) {
			String s = sc.next();
			for(int j=0; j<m; j++) {
				map[i][j]= Integer.parseInt(s.charAt(j));
			}
		}
		
		//확인
		boolean[][] ch = new boolean[n][m];
		//저장 q
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		//델타
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		//탐색
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(!ch[i][j] && map[i][j]!=0) {
					int[] array = new int[2];
					array[0]=i;
					array[1]=j;
					ch[i][j]=true;
					q.offer(array);
					
					while(!q.isEmpty()) {
						int cx = q.peek()[0];
						int cy = q.poll()[1];
						for(int k=0; k<4; k++) {
							int nx = cx+dx[k];
							int ny = cy+dy[k];
							if(nx<0 || ny<0 || nx>=n || ny>=m) continue;
							if(!ch[nx][ny] && map[nx][ny]>0) {
								array = new int[2];
								array[0]=nx;
								array[1]=ny;
								ch[nx][ny]=true;
								q.offer(array);
								map[nx][ny]=map[cx][cy]+1;
							}
						}
					}
				}
			}
		}
		System.out.println(map[n-1][m-1]);
	}

}

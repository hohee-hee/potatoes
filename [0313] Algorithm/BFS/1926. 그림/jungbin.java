package day0315;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class P1926_그림 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//도화지 세로 크기 n
		int n = sc.nextInt();
		//도화지 가로 크기 m
		int m = sc.nextInt();
		
		//도화지 배열
		int[][] arr = new int[n][m];
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				arr[i][j]= sc.nextInt();
			}
		}
		
		//델타 탐색
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		//저장 queue
		Queue<int[]> q = new ArrayDeque<>();
		
		//최대 그림 크기
		int max_s = 0;
		//그림 개수
		int cnt =0;
		
		int temp=0;
		
		//탐색
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(arr[i][j]==1) {
					temp=1;
					cnt++;
					arr[i][j]=0;
					
					int[] array = new int[2];
					array[0]=i;
					array[1]=j;
					q.offer(array);
					
					while(!q.isEmpty()) {
						array = q.poll();
						int cx = array[0];
						int cy = array[1];
						for(int k=0; k<4; k++) {
							if(cx+dx[k]<0 || cy+dy[k]<0 || cx+dx[k]>=n || cy+dy[k]>=m) continue;
							if(arr[cx+dx[k]][cy+dy[k]]==1) {
								arr[cx+dx[k]][cy+dy[k]]=0;
								temp++;
								
								array= new int[2];
								array[0] = cx+dx[k];
								array[1] = cy+dy[k];
								q.offer(array);
							}
						}
					}
					if(temp>max_s) max_s = temp;
				}
			}
		}
		System.out.print(cnt+"\n"+ max_s+"\n");
	}

}

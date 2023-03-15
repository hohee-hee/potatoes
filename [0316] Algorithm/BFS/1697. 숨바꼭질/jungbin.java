package day0315;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class P1697_숨바꼭질 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//수빈 위치 n
		int n = sc.nextInt();
		
		//동생 위치 k
		int k = sc.nextInt();
		
		//위치 배열
		int[] arr = new int[k+1];
		for(int ar : arr) {
			ar=0;
		}
		
		
		//최소 시간
		int min_s = Integer.MAX_VALUE;
		//델타
		int[] dx = {-1, 1, 2};
		
		//탐색 저장 큐
		Queue<int[]> q = new ArrayDeque<int[]>();
		
		for(int i=n; i<arr.length; i++) {
			//자기 좌표와 소요 최소 시간
			int[] array = new int[2];
			array[0]=i;
			array[1]= arr[i];
			q.offer(array);
			
			while(!q.isEmpty()) {
				int[] temp = q.poll();
				int nx = arr[0];
				int ns = arr[1];
				
				//탐색
				for(int a=0; a<3; a++) {
					int x;
					int s;
					if(a<2) {
						x = nx+dx[a];
						s = (ns!=0 && ns<ns+1)? ns:ns+1;
						arr[i]=s;
					}else {
						x = nx*dx[a];
						s = (ns!=0 && ns<ns+1)? ns:ns+1;
						arr[i]=s;
					}
					//범위 조건 제외
					if(x<0 || x>k) continue;
					int[] temp1 = new int[2];
					temp1[0]=x;
					temp1[1]=s;
					q.offer(temp1);
				}
			}
		}
		System.out.println(arr[k]);
	}

}

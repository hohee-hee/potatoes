  package main;

import java.util.Scanner;

public class Solution_2001파리퇴치 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//테스트 케이스 갯수를 받아온다
		int T = sc.nextInt();
		for(int tc=0; tc<T; tc++) {
			//땅의 크기
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			//파리를 잡을 크기
			int M = sc.nextInt();
			
			//값을 모두 입력받음
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			
			int max =0;
			// n-M 큼 범위를 돌리는데 그 돌리는 값 마다 파리 구역 탐색
			for(int i =0; i<=N-M; i++) {
				for(int j =0; j<=N-M; j++) {
					//파리 범위를 빼고 각 범위를 탐색한다
					int sum =0;
					//파리 어택 범위
					for(int k = 0; k<M; k++) {
						for(int l=0; l<M; l++) {
							sum += arr[i+k][j+l];
						}
					}
				if(sum > max) {
					max = sum;
				}
				}
			}
			
			System.out.println("#" + (tc+1)+ " " +max);
			
			
			
		}
		
		
	}

}
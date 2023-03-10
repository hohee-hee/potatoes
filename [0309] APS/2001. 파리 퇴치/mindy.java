import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		for(int t=1; t<=tests; t++) {
			int N = sc.nextInt(); // 배열 크기
			int M = sc.nextInt(); // 파리채 크기
			int[][] arr = new int[N][N];
			
			// 값 입력
			for(int i=0; i<N; i++) 
				for(int j=0; j<N; j++)
					arr[i][j] = sc.nextInt();
			
			// 최대값 구하기
			int max = 0;
			// 탐색
			for(int i=0; i<=N-M; i++) {
				for(int j=0; j<=N-M; j++) {
					// 파리채 크기만큼 계산
					int sum = 0; 
					for(int a=0; a<M; a++) {
						for(int b=0; b<M; b++) {
							sum += arr[i+a][j+b];
						}
					}
					if(sum > max) max = sum;
				}
			}
			
			System.out.println("#"+t+" "+max);
		}
	}
}

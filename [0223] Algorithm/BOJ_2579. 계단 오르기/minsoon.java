package main;

import java.util.Scanner;

public class Main_2579계단오르기 {
	
	// Integer로 객체를 선언해서 null 값을 표현 할 수 있게 만듦, 정수형 이긴함
	public static Integer dp[];
	public static int[] arr;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//연속으로 3개의 계단을 오를 수 없다.
		// 한개 또는 두개의 계단을 오를 수 있다.
		// 마지막 계단은 밟아야한다.
		
		int N = sc.nextInt();
		
		
		dp = new Integer[N+1];
		arr =  new int[N +1];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = sc.nextInt();
		}
		
		
		dp[0] = arr[0];
		dp[1] = arr[1];
		
		if(N>=2) {
			dp[2] = arr[1] + arr[2];
		}
		System.out.println(stair(N));
		
		
		
	}
	
	public static int stair(int N) {
		
		if(dp[N] == null) {
			// 윗 계단부터 내려가는데
			//첫번째 계단을 밟는다 가정하고, 첫번째랑 세번째를 밝거나 두번째를 밟는 값을 구해준다.
			dp[N] = Math.max(stair(N-2), stair(N-3) + arr[N-1]) + arr[N];
		}
		return dp[N];
	}
	

}
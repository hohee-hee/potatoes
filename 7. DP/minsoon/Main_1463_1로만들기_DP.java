package main;

import java.util.Scanner;

public class Main_1463_1로만들기_DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 각 단계에서 모든 경우의 수를 비교해서 최솟값을 도출은 dp
		
		
		
		
		int N = sc.nextInt();
	
		int[] dp = new int[N+1];
		dp[0] = 0;
		dp[1] = 0;
	
		for(int i = 2; i<=N; i++) {
			dp[i] = dp[i-1] + 1;
			
		}
	
	}
	
	
	
	
	
	}


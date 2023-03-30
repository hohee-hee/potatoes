import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //
		int[][] arr = new int[N+1][2]; // 길이, 보수
		for(int i=1; i<=N; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		int max = 0;
		int[] dp = new int[N+1];
		for(int i=1; i<=N; i++) { 
			int next = i+arr[i][0];
			// 먼저 본인 합해줘
			if(next-1 <= N) { dp[i] += arr[i][1]; }
			// 그다음 본인끝+1 지점에서 시작하는 상담 길이 만큼 업데이트
			if(next <= N) {
				for(int a=next; a<next+arr[next][0]; a++) {
					if(a <= N && dp[a] < dp[i]) dp[a] = dp[i];
				}
			}
			if(dp[i] > max) max = dp[i];
		}
		
		System.out.println(max);
	}
}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 집을 칠하는 비용이 1000보다 작거나 같아야한다.
		// 모든 집을 칠하는 최솟값
		// 1번과 2번은 색이 다르다
		// N 고 ㅏN-1 은 색이 다르다

		int N = sc.nextInt();
		int[][] dp = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();

			dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + r;
			dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + g;
			dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + b;

		}
		System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));

	}

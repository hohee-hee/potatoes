import java.util.Scanner;

public class Main_26099설탕배달2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		long N = sc.nextLong();

		// 봉투의 갯수
		int[] dp = new int[(N + 1)];

		if (N >= 3)
			dp[3] = 1;
		if (N >= 5)
			dp[5] = 1;
		for (int i = 6; i <= N; i++) {
			// 5로 나눠지면
			if (i % 5 == 0) {
				dp[i] = dp[i - 5] + 1;
			} else if (i % 3 == 0) {
				dp[i] = dp[i - 3] + 1;
			} else {
				if (dp[i - 3] != 0 && dp[i - 5] != 0) {
					dp[i] = Math.min(dp[i - 3], dp[i - 5]) + 1;
				}
			}
		}
		if(dp[(int) N] == 0) {
			System.out.println("-1");
			return;
		}System.out.println(dp[N]);

	}

}
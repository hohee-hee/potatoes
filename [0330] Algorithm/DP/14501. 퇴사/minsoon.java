import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		// 재귀를 통해 상담 받을 수 있는 날의 모든 경우를 받아온다.
		int[] time = new int[N];
		int[] point = new int[N];

		for (int i = 0; i < N; i++) {
			time[i] = sc.nextInt();
			point[i] = sc.nextInt();
		}

		int[] dp = new int[N + 1];

		for (int i = 0; i < N; i++) {
			if (i + time[i] < N+1) {
				// 다음에 추가되는 값이랑 // 지금 듣는거랑 가격을 비교한다.
				dp[i + time[i]] = Math.max(dp[i + time[i]], dp[i] + point[i]);
			}
			//0인 값이 넘어 올 수 잇기에 // 금액 0원인 것을 방지
			dp[i+1] = Math.max(dp[i], dp[i+1]);
		}
		System.out.println(dp[N]);

	}

}
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();sc.nextLine();

		int max = 0;

		char[][] arr = new char[N][M];
		int[][] dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLine().toCharArray();
		}

		// 각 대각선 까지 값을 돌려주면서 확인해준다.
		// 값은 뒤에서 부터, 윈쪽, 위, 왼위를 체크한다.
		// 셋 중 가장 작은 값에 1을 더해서 저장
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				dp[i][j] = arr[i][j] - '0';
				// 1을 만는 순간 맥스값 1로
				if (dp[i][j] == 1 && max == 0)
					max = 1;
				// 범위 안에 들어오고 각 값이 1이면 맨 끝 대각선에 1 더하기
				if (j > 0 && i > 0) {
					if (dp[i - 1][j] > 0 && dp[i][j - 1] > 0 && dp[i - 1][j - 1] > 0 && dp[i][j] == 1) {
						dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1])) + 1;
						max = Math.max(dp[i][j], max);
					}
				}

			}
		}
		/*for(int i =0; i<N; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}*/
		System.out.println(max*max);

	}

}
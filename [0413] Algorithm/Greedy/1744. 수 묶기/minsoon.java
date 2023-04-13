import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 음의 갯수가 짝수인 경우
		// 홀수인 경우
		// 홀수인 경우에서 0
		// 0까지는 두개씩 묶어서 곱을 해주면 된다.
		// 홀수개인 경우 따로 빼서 더해주면된다.
		// 양수는 뒤에서 부터 값을 보면서 내려준다.

		int n = sc.nextInt();
		int[] arr = new int[n];

		int yum = 0;

		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
			if (arr[i] <= 0)
				yum++;
		}
		// 정렬을 한다.
		Arrays.sort(arr);

		int ans = 0;
		// 음수인 경우 0 포함해서 카운트
		for (int i = 1; i < yum; i += 2) {
			ans += (arr[i - 1] * arr[i]);
		}

		// 음수가 홀수개 면 그냥 더하기
		if (yum % 2 == 1)
			ans += arr[yum - 1];

		// 양수가 홀수개면 더하기
		if ((n - yum) % 2 == 1)
			ans += arr[yum];

		// 양수 두개씩 묶어 더하기
		for (int i = n - 1; i > yum; i -= 2) {
			int gub = arr[i] * arr[i - 1];
			int sum = arr[i] + arr[i - 1];
			if (gub > sum) {
				ans += gub;
			} else {
				ans += sum;
			}

		}
		System.out.println(ans);
	}
}
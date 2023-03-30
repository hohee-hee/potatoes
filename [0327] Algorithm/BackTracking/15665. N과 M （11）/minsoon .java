import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M;
	static int[] arr;
	static int[] result;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N + 1];
		result = new int[M];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		combination(0);
		System.out.println(sb);

	}

	// idx : 해당 원소를 포함할지 안할지를 결정해야함.
	public static void combination(int idx) {

		if (idx == M) {// 다 뽑았다면
			for (int i = 0; i < M; i++) {
				sb.append(result[i]).append(" ");
			}
			sb.append("\n");
			return;
		}
		int ago = 0;
		for (int i = 0; i <= N; i++) {
			if (ago != arr[i]) {
				result[idx] = arr[i];
				ago = arr[i];
				combination(idx + 1);
			}

		}

	}
}
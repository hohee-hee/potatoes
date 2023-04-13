import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		long[] ans = new long[T];
		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			long[] arr = new long[N];
			//최대값을 
			long max = 0;
			// 계속 값을 갱신하고 최대값과의 차이를 계속 적어준다.
			// 최대값에서 빼는 거면 뒤로 
			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}
			for(int i=N-1; i>=0; i--) {
				if (arr[i] > max) {
					max = arr[i];
				} else {
					ans[tc] += (max - arr[i]);
				}
			}

		}
		for(long i : ans) {
			System.out.println(i);
		}

	}

}
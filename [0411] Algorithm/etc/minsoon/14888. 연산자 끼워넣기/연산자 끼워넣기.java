import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int[] num, ari, result;
	static int N, ans_max, ans_min;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		// 숫자를 담는 어레이
		num = new int[N];
		//기호를 담는 어레이
		ari = new int[N-1];
		result = new int[N-1];

		// 0 +, - 1, x2 , /3;
		visited = new boolean[N-1];
		
		//숫자 담기
		for(int i =0; i<N; i++) {
			num[i] = sc.nextInt();
		}
		// 기호 담기
		int in = 0;
		for(int i=0; i<4; i++) {
			int EA = sc.nextInt();
			for(int j = 0; j<EA; j++)
				ari[in++] = i;
		}
		ans_max = Integer.MIN_VALUE;
		ans_min = Integer.MAX_VALUE;
		//기호를 (N-1)! 개수가 나오게 여러 순서를 확인
		per(0);

		
		System.out.println(ans_max);
		System.out.println(ans_min);
	}

	static void per(int idx) {
		if (idx == N - 1) {	
			//숫자 계산
			// 값을 돌리면서 사칙연산을 계산한다
			// 계산은 순서대로 진행한다.
			int ans = num[0];
			for(int i =0; i<N-1; i++) {
				if(ari[i] == 0)  ans += num[i+1];
				if(ari[i] == 1)  ans -= num[i+1];
				if(ari[i] == 2)  ans *= num[i+1];
				if(ari[i] == 3)  ans /= num[i+1];		
			}
			ans_max = Math.max(ans_max, ans);
			ans_min = Math.min(ans_min, ans);

			
			
			return;
		}
		for (int i = idx; i < N - 1; i++) {
			swap(i, idx);
			per(idx + 1);
			swap(i, idx);
		}

	}

	static void swap(int a, int b) {
		int temp = ari[a];
		ari[a] = ari[b];
		ari[b] = temp;
	}

}
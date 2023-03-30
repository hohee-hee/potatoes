import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt(); 
		for(int t=1; t<=tests; t++) {
			int N = sc.nextInt(); // 동전의 가지수
			int[] coin = new int[N];
			for(int i=0; i<N; i++) coin[i] = sc.nextInt();
			int total = sc.nextInt(); // 만들어야할 금액
			
			//////
			int[] dp = new int[total+1];
			dp[0] = 1;
			for(int i=0; i<N; i++) {
				int tmp = coin[i];
				for(int j=0; j+tmp<=total; j++) {
					dp[j+tmp] += dp[j];
				}
			}
			
			System.out.println(dp[total]);
		}
		
	}
}
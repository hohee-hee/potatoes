import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정수 x에 사용할 수 있는 연산은 3개
		// 3으로 나눠지면 나누고
		// 2도 나누고
		// 1을 뺀다.
		
		
		int N = sc.nextInt();
		
		// 답을 구하는 친구
		int[] dp = new int[N+1];
		// 이동할때마다 값을 넣는 친구
		// 전 값이 어떤 값이 었을 지를 넣어준다/
		int[] move = new int[N+1];
		
		//거꾸로 올라가는 게 좋아보임
		dp[1] = 0;
				
		
		for(int i =2; i<=N; i++) {
			// 하나씩 더해준다.
			dp[i] = dp[i-1] + 1;
			move[i] = i-1; 
		// 3으로 나눠지는 경우
		if(i%3 ==0 && dp[i]>dp[i/3]+1) {
			dp[i] = dp[i/3]+1;
			move[i] = i/3; 
		}
			
		// 2로 나눠 지는 경우 // i 값은 항상 커야한다.
		if(i%2 ==0 && dp[i]>dp[i/2]+1) {
			dp[i] = dp[i/2]+1;
			move[i] = i/2;
		}

		}
		
		int num = dp[N];
		int idx = N;
		
		System.out.println(num);
		// 이동한 위치의 값들을 출력을 한다.
		System.out.print(N+ " ");
		for(int i = 0; i<num; i++) {
			System.out.print(move[idx] + " ");
			idx = move[idx];
		}

		
		
		
		
		
	}
	

}
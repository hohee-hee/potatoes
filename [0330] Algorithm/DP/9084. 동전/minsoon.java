import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
 			//동전의 가지수
			int N = sc.nextInt();
			//동전을 담는 통
			int[] arr= new int[N];
			
			for(int i =0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			// 만들어야 할 금액
			int money = sc.nextInt();
			
			int[] dp = new int[money+1];
			
			dp[0] =1;
		
			// 총 갯수 전 dp더해서 구함
			// 코인 마다 갯수 카운트
			// 지급 dp 값은 돈마다 갯수, 
			// 현재 돈은  = 이전 동전으로 만든것 + (현재 돈 - 현재 동전) 개수
			// 10원 -> 2,3,5
			// [1, 0, 1, 1, 1, 2, 2, 2, 3, 3, 4]
			
			for(int i =0; i<N; i++) {
				// 1원 일때 2월 일때
				for(int j = arr[i]; j<=money; j++) {
					dp[j] += dp[j-arr[i]];
					//System.out.println(Arrays.toString(dp));
				}
			}

			System.out.println(dp[money]);
			
		}
	}

		
		
		
		
	}
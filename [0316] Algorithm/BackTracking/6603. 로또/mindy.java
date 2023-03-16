import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr;
	static int[] ans;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			N = sc.nextInt(); if(N == 0) return;
			
			arr = new int[N];
			for(int i=0; i<N; i++) arr[i] = sc.nextInt();
			ans = new int[6];
			
			bt(0, 0);
			System.out.println();
		}
	}
	
	static void bt(int n, int now) {
		if(n == 6) {
			// 출력
			for(int i=0; i<6; i++) System.out.print(ans[i] + " ");
			System.out.println();
			return;
		}
		
		for(int i=now; i<N; i++) {
			ans[n] = arr[i];
			bt(n+1, i+1);
		}
	}
}
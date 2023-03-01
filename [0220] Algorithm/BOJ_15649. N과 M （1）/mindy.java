import java.util.Arrays;
import java.util.Scanner;

public class Main{
	static int N;
	static int M;
	static boolean[] chk;
	static int[] arr;
	static int[] ans;
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = i+1;
		ans = new int[M];
		chk = new boolean[N];		
		
		backTracking(0);
	}
	
	public static void backTracking(int k) {
		if(k == M) {
			for(int i=0; i<M; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!chk[i]) {
				ans[k] = arr[i];
				chk[i] = true;
				backTracking(k+1);
				chk[i] = false;
			}
		}
	}
}


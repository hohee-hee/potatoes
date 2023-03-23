import java.util.Scanner;

public class Main {
	static int N;
	static int[] arr; 
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		bt(1);
		System.out.println(cnt);
	}
	
	static void bt(int k) {
		if(k == N+1) { cnt++; return; }
		
		for(int i=0; i<N; i++) {
			if(arr[i] == 0 && chk(i, k)) {
				arr[i] = k;
				bt(k+1);
				arr[i] = 0;
			}
		}
	}
	static boolean chk(int i, int k) {
		for(int a=0; a<N; a++) {
			if(arr[a] > 0 && (arr[a] == k-Math.abs(i-a) 
					|| arr[a] == k+Math.abs(i-a))) return false;
		}
		return true;
	}
}

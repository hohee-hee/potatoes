import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	static int M;
	static int[] arr;
	static int[] ans;
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); 
		M = sc.nextInt();
		arr = new int[N];
		ans = new int[M];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		bt(0, 0);
		bw.close();
	}
	static void bt(int n, int now) throws IOException {
		if(n == M) {
			for(int i=0; i<M; i++) bw.write(ans[i]+" ");
			bw.write("\n");;
			return;
		}
		
		for(int i=now; i<N; i++) {
			ans[n] = arr[i];
			bt(n+1, i);
		}
	}
}
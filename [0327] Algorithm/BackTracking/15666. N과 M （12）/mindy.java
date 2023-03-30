import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
	static int N, M;
	static Integer[] arr, ans;
	static BufferedWriter bw;
	public static void main(String[] args) throws IOException {
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = new Integer[M];

		Set<Integer> s = new HashSet<>();
		for(int i=0; i<N; i++) s.add(sc.nextInt());
		arr = s.toArray(new Integer[0]);
		Arrays.sort(arr);
		
		bt(0, 0);
		bw.close();
	}
	
	static void bt(int k, int now) throws IOException {
		if(k == M) {
			for(int a=0; a<M; a++) bw.write(ans[a] + " ");
			bw.write("\n");
			return;
		}
		for(int i=now; i<arr.length; i++) {
			ans[k] = arr[i];
			bt(k+1, i);
		}
	}
}

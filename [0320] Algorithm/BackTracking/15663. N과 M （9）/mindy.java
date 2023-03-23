import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main{
	static int N;
	static int M;
	static int[] arr;
	static boolean[] chk;
	static int[] ans;
	static Set<String> s = new LinkedHashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N];
		chk = new boolean[N];
		ans = new int[M];
		for(int i=0; i<N; i++) arr[i] = sc.nextInt();
		Arrays.sort(arr);
		
		bt(0);
		
		Iterator<String> it = s.iterator();
		while(it.hasNext()) System.out.println(it.next().trim());
	}
	static void bt(int n) {
		if(n == M) { // 출력
			String tmp = "";
			for(int i=0; i<M; i++) tmp += ans[i]+" ";
			s.add(tmp);
			return;
		}
		
		for(int i=0; i<N; i++) {
			if(!chk[i]) {
				chk[i] = true;
				ans[n] = arr[i];
				bt(n+1);
				chk[i] = false;
			}
		}
	}
}
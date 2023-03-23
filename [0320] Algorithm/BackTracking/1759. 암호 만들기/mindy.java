import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int L;
	static int C;
	static String[] arr;
	static String[] ans; 
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		L = sc.nextInt();
		C = sc.nextInt(); sc.nextLine();
		arr = new String[C];
		chk = new boolean[C];
		ans = new String[L];
		for(int i=0; i<C; i++) arr[i] = sc.next();
		Arrays.sort(arr);

		bt(0, 0);
	}
	
	static void bt(int n, int now) {
		if(n == L) { // 출력
			int chkMoeum = 0;
			int chkJaeum = 0;
			for(int i=0; i<L; i++) {
				if(ans[i].equals("a") || ans[i].equals("e") || ans[i].equals("i") 
						|| ans[i].equals("o") || ans[i].equals("u"))
					chkMoeum++;
				else chkJaeum++;
			}
			if(chkMoeum >= 1 && chkJaeum >= 2) {
				for(int i=0; i<L; i++) System.out.print(ans[i]);
				System.out.println(); 
			}
			return;
		}
		for(int i=now; i<C; i++) {
			if(!chk[i]) {
				chk[i] = true;
				ans[n] = arr[i];
				bt(n+1, i);
				chk[i] = false; 
			}
		}
	}
}

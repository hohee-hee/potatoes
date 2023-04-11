import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static int N, M, min;
	static int[] ans;
	static ArrayList<int[]> jip = new ArrayList<>();
	static ArrayList<int[]> chkn = new ArrayList<>();
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = new int[M];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				int tmp = sc.nextInt();
				if(tmp == 1) jip.add(new int[] {j, i});
				else if(tmp == 2) chkn.add(new int[] {j, i});
			}
		}
		arr = new int[chkn.size()][jip.size()];
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) 
				arr[i][j] = Math.abs(chkn.get(i)[0]-jip.get(j)[0]) 
								+ Math.abs(chkn.get(i)[1]-jip.get(j)[1]); 
		}
		
		min = Integer.MAX_VALUE; 
		bt(0,0);
		System.out.println(min);
	}
	static void bt(int k, int now) {
		if(k == M) {
			int tmp = 0;
			for(int j=0; j<jip.size(); j++) {
				int mmin = Integer.MAX_VALUE;
				for(int c=0; c<M; c++) {
					if(mmin > arr[ans[c]][j]) mmin = arr[ans[c]][j];
				}
				tmp += mmin;
			}
			if(tmp < min) min = tmp;
			return;
		}
		
		for(int i=now; i<chkn.size(); i++) {
			ans[k] = i;
			bt(k+1, i+1);
		}
	}
}
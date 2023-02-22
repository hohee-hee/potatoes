package potato;

import java.util.Arrays;
import java.util.Scanner;

public class P15650 {
	//n과 m (2)
	//1부터 n까지 n개의 수 중
	// 중복 없이 m개 구하기
	//오름차순 출력
	private static int[] arr;
	private static int n;
	private static int m;
	private static boolean[] check;
	private static int[] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m= sc.nextInt();
		arr= new int[n];
		check = new boolean[n];
		ans = new int[m];
		for(int k=0; k<n; k++) {
			arr[k]= k+1;
		}
		
		backTracking(0);
	}
	
	private static void backTracking(int i) {
		
		if(i==m) {
			Arrays.sort(ans);
			for(int j=0; j<m; j++) {
				System.out.print(ans[j]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int j=0; j<n; j++) {
			if(!check[j] && j>=i) {
				ans[i] = arr[j];
				check[j] = true;
				backTracking(i+1);
				check[j] = false;
			}
		}
	}

}

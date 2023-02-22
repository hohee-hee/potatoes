package potato;

import java.util.Scanner;

public class P15649 {
	//n과 m (1)
	//1에서 n까지의 수 n개 중
	//m개 중복 x 고르기
	
	private static int[] arr;
	private static int n;
	private static int m;
	private static boolean[] check;
	private static int[] ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n= sc.nextInt();
		m= sc.nextInt();
		arr= new int[n];
		check = new boolean[n];
		ans = new int[m];
		for(int k=0; k<n; k++) {
			arr[k]=k+1;
		}
		
		backTracking(0);
	}
	
	private static void backTracking(int i) {
		if(i==m) {
			for(int j=0; j<m; j++) {
				System.out.print(ans[j]+" ");
			}
			System.out.println();
			
			return;
		}
		
		for(int j=0; j<n; j++) {
			if(!check[j]) {
				ans[i]=arr[j];
				check[j]=true;
				backTracking(i+1);
				check[j] = false;
			}
		}
	}
}

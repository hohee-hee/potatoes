package hw;

import java.util.Scanner;

public class P15651_n과m3 {
	
	static int m;
	static int[] ans;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1부터 n까지 수 중
		n = sc.nextInt();
		//중복 가능 m개
		m = sc.nextInt();
		
		//정답 사전 순 증가
		ans = new int[m];
		
		back(0);
		
	}
	
	private static void back(int k) {
		//기저조건
		if(k==m) {
			for(int i=0; i<m; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		
		//유도조건
		for(int i=1; i<=n; i++) {
			ans[k]=i;
			back(k+1);
			
		}
	}

}

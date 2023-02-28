package potato;

import java.util.Scanner;

public class P02_2747 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//n
		int n = sc.nextInt();
		int f = fibo(n);
		System.out.println(f);
	}
	
	public static int fibo(int n) {
		int ans =0;
		for(int i=0; i<=n; i++) {
			
			if(i==0) {
				ans=0;
			}else if(i==1) {
				ans=1;
			}else {
				ans=fibo(i-1)+fibo(i-2);
			}
		}
		return ans;		
	}
}

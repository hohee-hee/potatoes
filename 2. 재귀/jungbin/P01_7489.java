package potato;

import java.util.Scanner;

public class P01_7489 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//test case
		int t = sc.nextInt();
		for(int i=0; i<t; i++) {
			//정수
			int n = sc.nextInt();
			
			int ans = right(n);
			System.out.println(ans);
		}	
	}
	
	//최우측 수 함수
	public static int right(int n) {
		if(n==1) {
			return 1;
		}else {
			int r = right(n-1)*n;
			while(r%10==0) {
				r=r/10;
			}
			return r%10;
		}
	}
}

package hw;

import java.util.Scanner;

public class P6603_로또 {
	
	static int[] ans;
	static int k;
	static boolean[] ch;
	static int[] s;
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			//49개의 수 중 고른 k개 수
			k=sc.nextInt();
			if(k==0) break;
			
			//고른 k개 수 집합 s
			s = new int[k];
			for(int i=0; i<k; i++) {
				s[i]=sc.nextInt();
			}
			
			ch = new boolean[k];
			ans = new int[6];
			back(0);
			
			System.out.println();
			
		}	
	}
	
	private static void back(int n) {
		if(n==6) {
			for(int i=0; i<6; i++) {
				System.out.print(ans[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0; i<k; i++) {
			if(!ch[i] && (n==0 || ans[n-1]<s[i])) {
				ch[i]=true;
				ans[n]=s[i];
				back(n+1);
				ch[i]=false;
			}
		}
	}
}

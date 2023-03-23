package hw;

import java.util.Arrays;
import java.util.Scanner;

public class P1759_암호 {
	
	static int l, c;
	static char[] arr, ans;
	static boolean[] ch;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//서로 다른 l개 암호
		l = sc.nextInt();
		//c개 문자
		c = sc.nextInt();
		//문자
		arr = new char[c];
		for(int i=0; i<c; i++) {
			arr[i]=sc.next().charAt(0);
		}
		Arrays.sort(arr);
		ans = new char[l];
		ch = new boolean[c];
		cho(0, 0);

			
		
	}
	
	static void cho(int k, int j) {
		if(k==l) {
			int a=0;
			int b=0;
			for(int i=0; i<l; i++) {
				if(ans[i]=='a' || ans[i]=='e'|| ans[i]=='i'|| ans[i]=='o'|| ans[i]=='u')
					a++;
				else b++;
			}
			if(a>=1 && b>=2) {
				for(int i=0; i<l; i++) {
					System.out.print(ans[i]+" ");
				}
				 System.out.println();
				 return;
			}
			else return;
		}
		
		for(int i=j; i<c; i++) {
			if(!ch[i] ) {
				ans[k]=arr[i];
				ch[i]=true;
				cho(k+1, i+1);
				ch[i]=false;
			}	
		}

	}

}

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int ans = 1;
		
		while(true) {
			if((num+1)/3 <= ans*(ans-1)) break;
			ans++;
		}
		
		System.out.println(ans);
	}
}

/*
 * 2~7 -> 2
 * 8~19 -> 3
 * 20~37 -> 4
 * 38~61 -> 5
 * +6 +12 +18
 * 
 * 2+3*(n-2)(n-1) ~ 1+3*(n-1)n = a
 * (a+1)/3 <= n(n-1)
 * 2 -> 1	2
 * 5 -> 2	2
 * 7 -> 2	2
 * 8 -> 3	3(6)
 * 13 -> 4	
 * 19 -> 6
 * 20 -> 7 	4(12)
 * 37 -> 12
 * 38 -> 13	5
 */

import java.util.Scanner;

public class Main{
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println(calc(n));
	}
	
	public static int calc(int n) {
		int[] num = new int[n+1];
		for(int i=0; i<n; i++) {
			num[i] = 1000000;
		}
		num[n] = 1;
		
		for(int i=n; i>0; i--) {
			if(num[i] != 0) { // 사실 3번 연산 때문에 필요 없긴할듯
				if(i%3 == 0) num[i/3] = min(num[i/3], num[i] + 1);
				if(i%2 == 0) num[i/2] = min(num[i/2], num[i] + 1);
				num[i-1] = min(num[i-1], num[i] + 1);
			}
		} 
		return num[1] - 1;
	}
	
	public static int min(int a, int b) {
		return (a < b)? a : b;
	}
}


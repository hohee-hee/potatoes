package hw;
//ㅜㅜ
import java.util.Scanner;

public class P12852_1로만들기2_1 {
	static int min_t, temp1, temp2, temp3;
	static int[] cnt, con;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//1로 만들 숫자 n
		int n = sc.nextInt();
		
		//연산 수 배열
		cnt = new int[n+1];
		//포함 수 배열
		con = new int[n+1];
		
		cnt[1]=0;
		temp1=temp2=temp3=0;
		
		for(int i=2; i<=n; i++) {
			dp(i);
		}
		
		System.out.println(cnt[n]);
		System.out.print(n+" ");
		while(true) {
			System.out.print(con[n]+" ");
			n=con[n];
			if(con[n]==1) {
				break;
			}
		}
		
	}
	private static void dp(int n) {
		min_t = Integer.MAX_VALUE;

		
		if(n%3==0) {

			temp1=cnt[n/3]+1;
			if(min_t>temp1) {
				min_t=temp1;
				con[n]=n/3;
			}

		}
		if(n%2==0) {

			temp2=cnt[n/2]+1;
			if(min_t>temp2) {
				min_t=temp2;
				con[n]=n/2;
			}

			
		}
		if(n>1) {

			temp3=cnt[n-1]+1;
			if(min_t>temp3) {
				min_t=temp3;
				con[n]=n-1;
			}

		}
		cnt[n]=min_t;
		
	}
}

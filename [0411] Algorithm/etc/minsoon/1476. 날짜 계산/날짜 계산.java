import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//  수 3개를 이용해 연도를 나타낸다.
		//  지구E(1-15)  태양S(1-28)  달M(1-19) 
		//  1년이 지나면 3개 증가한다.
		int E = sc.nextInt();
		int S = sc.nextInt();
		int M = sc.nextInt();
		
		if(E == 15) E = 0;
		if(S == 28) S = 0;
		if(M == 19) M = 0;
		
		int cnt = 1;
		
		
		int a = 1;
		int b = 1;
		int c = 1;
		
		while(true) {
			if(a == E && b == S && c ==M ) {
				System.out.println(cnt);
				return;
			}
			cnt++;
			a += 1;
			b += 1;
			c += 1;
			a = (a%15);
			b = (b%28);
			c = (c%19);
		}
			
	}


}
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배달 할 무게 n
		int n = sc.nextInt();
		
		int ans = -1;
		
		int fi =0;
		fi=n/5;
		n=n%5;
		if(n==0) ans = fi;
		else if(n%3==0) {
			int th = n/3;
			ans = fi+th;
		}else {
			while(fi>0) {
				fi--; 
				n+=5;
				if(n%3==0) {
					int th = n/3;
					ans = fi+th;
					break;
				}
			}
		}
		System.out.println(ans);
		sc.close();
		
	}

}

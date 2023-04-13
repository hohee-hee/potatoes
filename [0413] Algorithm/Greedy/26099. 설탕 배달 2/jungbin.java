import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//배달할 설탕 무게  n
		long n = sc.nextLong();
		
		long ans=-1;
		//최대 5 가능 수
		long fi = n/5;
		n=n%5;
		if(n==0) ans = fi;
		//나머지가 남는경우 3 가능 수 구하기
		else if(n%3==0) {
			long th = n/3;
			ans = fi+th;
		}else {
			//5의 가능 수를 줄이면서 찾기
			while(fi!=0) {
				fi-=1;
				//**
				n+=5;
				if(n%3==0) {
					long th = n/3;
					ans = fi+th;
					break;
				}
			}
		}
		System.out.println(ans);
		sc.close();
	}

}

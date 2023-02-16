package test;


import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {	
	public static void main(String args[]) throws Exception	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int test_case = Integer.parseInt(br.readLine());
		
		for(int i = 0 ; i < test_case ; i++) {
			int get = Integer.parseInt(br.readLine());
			long n = (long) get;
			long num = fact(n); //팩토리얼 함수 호출
			System.out.println(num);	
		}
	}

	static long fact(long n) {
		if(n == 1) {
			return 1;
		}	

		long check = n*fact(n-1);
		int cnt = 0;
		while(true) {		
			check = check%10;
			if(check != 0) {
				break;
			}else {
				check = check / 10;
			}
		}
		return check;
	}
	

}

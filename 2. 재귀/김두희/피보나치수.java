import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		System.out.println(fibonacci(N));
	}
	
	private static int fibonacci(int n) {
		// n=0일 때는 0을 반환
		// n=1일 때는 1을 반환
		// n>=2일 때는 fibonacci(n-1)+fibonacci(n-2) 반환
		if(n==0) return 0;
		else if(n==1) return 1;

		return fibonacci(n-1) + fibonacci(n-2);
	}
}

------------------------------------------------------------------------------------------

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int n = 0;
		int m = 1;
		int tmp;
		for(int i=0; i<N; i++) {
			tmp = n;
			n = n+m;
			m = tmp;
		}
		System.out.println(n);
	}
}

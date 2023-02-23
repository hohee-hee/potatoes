import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{		
	public static void main(String args[]) throws Exception	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		System.out.println(fibo(N));
	}
	
	static int fibo(int num) {
		if(num == 0) {
			return 0;
		}
		else if(num == 1) {
			return 1;
		}
		return fibo(num-1) + fibo(num-2);
	}

}
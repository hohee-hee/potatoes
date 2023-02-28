import java.io.*;

public class test {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for(int i = 0 ; i < t ; i ++) {
			int n = Integer.parseInt(br.readLine());
			sb.append((fact(n)) + "\n");
		}		
		System.out.println(sb);			
	}
	
	public static int fact(int n) {
		if(n == 1) { return 1; }
		
		int num = n * fact(n-1);
		
		while(true) {
			if(num%10 != 0) {
				num=num%10000;
				break;
			}
			else {
				num /= 10;
			}
		}		
		return num%10;			
	}
}

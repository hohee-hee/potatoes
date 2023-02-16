import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int n = Integer.parseInt(bf.readLine());
		
		for(int i=0; i<n; i++){
			int num = Integer.parseInt(bf.readLine());
			
			int ans = fact(num);
			while(ans % 10 == 0) {
				ans /= 10;
			}
			bw.write((ans%10)+"\n");
			
		}
		bw.close();
	}
	
	public static int fact(int N) {
		if(N==1) return 1;
		return fact(N-1) * N;
	}
}
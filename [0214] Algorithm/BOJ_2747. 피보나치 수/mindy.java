import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int num = Integer.parseInt(bf.readLine());
		
		bw.write(fibonacci(num)+"\n");
		bw.close();
	}
	
	public static int fibonacci(int N) {
	    if (N == 0)	return 0;
	    if (N == 1)	return 1;
	    return fibonacci(N - 1) + fibonacci(N - 2);
	}
}
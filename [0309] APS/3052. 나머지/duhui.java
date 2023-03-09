import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 42칸의 배열을 만들고 시작한다.
		int[] list = new int[42];
		
		// array에 각 숫자를 42로 나눈 나머지의 idx를 올려준다.
		for(int i=0; i<10; i++) {
			list[Integer.parseInt(br.readLine())%42]++;
		}
		
		br.close();
			
		// 배열을 돌며 값이 있는 idx의 수만큼 cnt를 증가시킨다.		
		int cnt = 0;
		for(int i:list) {
			if(i!=0) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}

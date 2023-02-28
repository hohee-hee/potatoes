package firstProject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력으로 주어지는 N과 K를 받는다.
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
        // 지워지는 숫자의 개수를 체크할 cnt와
        // 지워지는 숫자를 담을 num을 선언한다.
		int cnt = 0;
		int num = 0;
        
        // index는 0부터 시작이므로 수와 인덱스를 맞춰주기 위해 
        // 소수를 담을 N+1 크기의 boolean 배열을 만든다. 
		boolean[] Prime = new boolean[N+1];
        
		loop:
		for(int i=2; i<=N; i++) {
            
            // 2부터 시작해서 2의 배수인 인덱스를 모두 true로 변경하며 cnt를 올리고
            // cnt가 K와 같아질 때의 인덱스값을 num에 담아 반환한다.
			for(int j=i; j<=N; j+=i) {
				if(Prime[j] == false) {
					Prime[j] = true;
					cnt++;
				}
				if(cnt == K) {
					num = j;
					break loop;
				}
			}
		}
		System.out.println(num);
		
	}
}
//민태 안녕.... 대충 어떤 식으로 풀어야 하는 지는 알겠는데... 아직 부족 나에게 시간 좀 주겠니? 알 수 있을 것 같아

package potato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P07_15649 {
	public static StringBuilder sb = new StringBuilder();
	public static int n;
	public static int m;
	public static boolean[] c;
	public static int[] a;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		c = new boolean[n+1];
		a = new int[n+1];
		
		
		go(0);
		
		System.out.println(sb);
	}
	
	public static void go(int index) {
		//인덱스가 마지막 위치에 도달하면 수열 출력
		if(index == m) { 
			for(int i=0; i<m; i++) {
				sb.append(a[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		// 1부터 ~ N개의 수를 선택
		for(int i=1; i<=n; i++) {
			//선택 여부
			if(c[i]) continue; 
			c[i] = true;  
			a[index] = i;
			//위치 1증가 재귀
			go(index+1); 
			c[i] = false; 
		}
	}

}

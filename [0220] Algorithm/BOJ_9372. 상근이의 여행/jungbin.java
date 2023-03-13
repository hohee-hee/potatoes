//민정이 안녕....
//민정이 안녕 이건 무슨 문제야?... 트리를 사용한 풀리라는데 가져와 봤지만 난 모르겠다
//케이스를 트리로 만드는 것까지는 나도 할 수 있었엉ㅎ



package potato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P08_9372 {
	public static void main(String[] args) throws NumberFormatException, IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            for (int j = 0; j<M; j++) {
                br.readLine();
            }

            sb.append(N-1).append("\n");

        }
		
		System.out.println(sb.toString());
    }
}

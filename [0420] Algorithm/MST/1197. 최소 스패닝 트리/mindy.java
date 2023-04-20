import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	static int[] grp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int[][] edges = new int[E+1][3]; // 시작, 끝, 가중치
		for(int i=1; i<=E; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken());
			edges[i][1] = Integer.parseInt(st.nextToken());
			edges[i][2] = Integer.parseInt(st.nextToken());
		} // 입력 끝
		
		// edges 가중치 순으로 정렬하기
		Arrays.sort(edges, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		// select 시작
		grp = new int[V+1]; // 초기화
		for(int i=1; i<=V; i++) grp[i] = i;
		
		int ans = 0; // 답
		int cnt = 0; // 뽑을 개수 저장
		for(int i=0; i<=E; i++) {
			int x = edges[i][0];
			int y = edges[i][1];
			if(x == 0 && y == 0) continue;
			if(findset(x) != findset(y)) { //사이클이 아님
				union(x, y);
				ans += edges[i][2]; //가중치 더하기
				cnt++;
			}
			if(cnt == (V-1)) break;
		}
		System.out.println(ans);
	}
	
	static int findset(int x) { 
		if(x == grp[x]) return x;
		return findset(grp[x]);
	}
	static void union(int x, int y) { //같은 그룹으로 묶기
		grp[findset(y)] = findset(x); 
	}
}

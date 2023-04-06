import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static int N;
	static int[][] map;
	static Queue<Integer> q = new ArrayDeque<>();
	static HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt();
		map = new int[N][N];
		
		for(int i=0; i<N*N; i++) {
			int key = sc.nextInt();
			q.add(key);
			ArrayList<Integer> al = new ArrayList<>();
			for(int a=0; a<4; a++) al.add(sc.nextInt());
			hm.put(key, al);		
		}
		
		while(!q.isEmpty()) {
			int s = q.poll();
			int maxf = -1;
			int[] tmp = new int[3]; // x, y, 빈자리 수
			
			for(int y=0; y<N; y++) { // 자리 탐색
				for(int x=0; x<N; x++) {
					int fr = dfChk(x, y, hm.get(s));
					int em = emChk(x, y);
					
					if(map[y][x] == 0 && 
							(fr > maxf || (fr == maxf && em > tmp[2]))) {
						tmp[0] = x; 
						tmp[1] = y;
						tmp[2] = em;
						if(fr > maxf) maxf = fr;
					} 
				}
			}
			map[tmp[1]][tmp[0]] = s;
		}
		
		// 점수계산
		int score = 0;
		for(int y=0; y<N; y++) { 
			for(int x=0; x<N; x++) { 
				int df = dfChk(x, y, hm.get(map[y][x]));
				if(df == 1) score += 1;
				else if(df == 2) score += 10;
				else if(df == 3) score += 100;
				else if(df == 4) score += 1000;
			}
		}
		System.out.println(score);
	}
	
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int dfChk(int x, int y, ArrayList<Integer> al) {
		int fr = 0;
		for(int d=0; d<4; d++) { // 사방 친구 탐색 
			if(x+dx[d] >= 0 && x+dx[d] < N 
					&& y+dy[d] >= 0 && y+dy[d] < N
					&& al.contains(map[y+dy[d]][x+dx[d]])) fr++;						
		} // 사방으로 친구 몇명있는지 저장 다 함
		return fr;
	}
	static int emChk(int x, int y) {
		int em = 0;
		for(int d=0; d<4; d++) { // 사방 빈자리 탐색
			if(x+dx[d] >= 0 && x+dx[d] < N 
					&& y+dy[d] >= 0 && y+dy[d] < N
					&& map[y+dy[d]][x+dx[d]] == 0) em++;						
		} 
		return em;
	}
}

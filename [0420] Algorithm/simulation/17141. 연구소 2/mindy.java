import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, blank=0, min = Integer.MAX_VALUE;
	static int[][] arr;
	static int[] cho;
	static ArrayList<int[]> hubo = new ArrayList<>(); // 2인곳(바이러스 놓을 수 있는 곳) 위치 저장
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][N]; 
		cho = new int[M]; // 선택한 시작지점 번호 저장
		for(int y=0; y<N; y++) {
			st = new StringTokenizer(br.readLine());
			for(int x=0; x<N; x++) {
				arr[y][x] = Integer.parseInt(st.nextToken());
				if(arr[y][x] == 0) blank++;
				if(arr[y][x] == 2) hubo.add(new int[] {x, y});
			}
		}
		blank += hubo.size()-M;
		
		if(blank == 0) { System.out.println(0); return; }
		
		bt(0, 0);
		System.out.println(min == Integer.MAX_VALUE? -1 : min);
	}
	static void bt(int k, int now) { // 시작지점 고르기
		if(k == M) {
			chk();
			return;
		}
		
		for(int i=now; i<hubo.size(); i++) {
			cho[k] = i;
			bt(k+1, i+1);
		}
	}
	static void chk() { // 시작지점 선택 후 계산하기
		int[][] map = new int[N][N];
		int cnt = 0, max = 0;
		Queue<int[]> q = new ArrayDeque<>();
		for(int i=0; i<M; i++) { 
			q.add(hubo.get(cho[i]));
			map[hubo.get(cho[i])[1]][hubo.get(cho[i])[0]] = 1; // 헷갈리니까 1로 시작하고 나중에 1빼겠음
		}
		
		while(!q.isEmpty()) {
			int qSize = q.size();
			for(int i=0; i<qSize; i++) {
				int x = q.peek()[0];
				int y = q.poll()[1];
				for(int d=0; d<4; d++) {
					int nx = x + dx[d];
					int ny = y + dy[d];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N
							|| map[ny][nx] != 0 || arr[ny][nx] == 1) continue;
					
					map[ny][nx] = map[y][x]+1;
					q.add(new int[] {nx, ny});
					cnt++;
					if(max < map[ny][nx]) max = map[ny][nx];
				}
			}
			if(cnt == blank) { // 안채운 곳 없이 다 참, 고립된 곳이 있는 경우 여기 안들어감
				if(min > max-1) min = max-1; 
				break;// 확인 
			}
		}
	}
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
}

/*
* 시작하자마자 바이러스 다 퍼지는 경우 처리
*/

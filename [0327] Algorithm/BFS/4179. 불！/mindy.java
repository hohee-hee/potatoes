import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static String[][] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); 
		M = Integer.parseInt(st.nextToken()); 
		Queue<int[]> q = new ArrayDeque<>();
		arr = new String[N][M];
		int[] hu = null;
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<M; j++) { 
				arr[i][j] = tmp.substring(j, j+1); 
				if(arr[i][j].equals("J")) { hu = new int[] {j, i, 1}; } 
				else if(arr[i][j].equals("F")) q.offer(new int[] {j, i, -1}); 
			}
		}
		q.offer(hu);
		
		// bfs
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		int dis = 0;
		boolean[][] chkFire = new boolean[N][M];
		boolean[][] chkHu = new boolean[N][M];
		out:
		while(!q.isEmpty()) {
			int x = q.peek()[0];
			int y = q.peek()[1];
			int chkNum = q.poll()[2];
			for(int i=0; i<4; i++) {
				int cx = x + dx[i];
				int cy = y + dy[i];
				
				if(chkNum == -1) { // 불
					if(cx >= 0 && cy >= 0 && cx < M && cy < N && !chkFire[cy][cx]) {
						if(!arr[cy][cx].equals("#") && !arr[cy][cx].equals("F")) {
							arr[cy][cx] = "F";
							chkFire[cy][cx] = true;
							q.offer(new int[] {cx, cy, -1});
						}
					}
				}	
				// 인간
				else {
					if(cx < 0 || cy < 0 || cx >= M || cy >= N) { dis = chkNum; break out; }
					else if(arr[cy][cx].equals(".") && !chkHu[cy][cx]) {
						chkHu[cy][cx] = true;
						q.offer(new int[] {cx, cy, chkNum+1});
					}
				}
			}
		}
		if(dis == 0) { System.out.println("IMPOSSIBLE"); }
		else System.out.println(dis);
	}
}
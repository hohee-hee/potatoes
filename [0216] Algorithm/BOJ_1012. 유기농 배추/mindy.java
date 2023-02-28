import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int tests = Integer.parseInt(br.readLine());
		
		for(int t=0; t<tests; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 
			int M = Integer.parseInt(st.nextToken()); // 
			int bechuNum = Integer.parseInt(st.nextToken());
			int[][] map = new int[N][M];
			// 배추 심기
			for(int i=0; i<bechuNum; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken()); 
				int y = Integer.parseInt(st.nextToken()); 
				map[x][y] = 1; 
			}
			
			// 사방
			int[] dx = { -1, 1, 0, 0 };
			int[] dy = { 0, 0, -1, 1 };
			// 큐
			Queue<int[]> queue = new ArrayDeque<>();
			
			int cnt = 0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(map[i][j] == 1) {
						map[i][j] = 0;
						cnt++;
						
						int[] tmp = new int[2];
						tmp[0] = i; tmp[1] = j;
						queue.offer(tmp);
						
						while(!queue.isEmpty()) {
							tmp = queue.poll();
							int cx = tmp[0];
							int cy = tmp[1];
							
							for(int k=0; k<4; k++) {
								if(cx+dx[k] >= 0 && cx+dx[k] < N 
										&& cy+dy[k] >= 0 && cy+dy[k] < M
										&& map[cx+dx[k]][cy+dy[k]] == 1) {
									map[cx+dx[k]][cy+dy[k]] = 0;
									int[] ttmp = new int[2];
									ttmp[0] = cx+dx[k];
									ttmp[1] = cy+dy[k];
									queue.offer(ttmp);
								}
							}
							
						}
						
					}
				}
			}
			bw.write(cnt+"\n");
		}
		bw.close();
	}
}

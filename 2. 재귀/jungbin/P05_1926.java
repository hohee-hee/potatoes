import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P05_1926{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] map = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		Queue<int[]> queue = new ArrayDeque<>();
		
		int cnt = 0; int max_size = 0;

		for(int x=0; x<n; x++) {
			for(int y=0; y<m; y++) {
				if(map[x][y] == 1) {
					cnt++;
					int size = 1;
					map[x][y] = 0;
					
					int[] array = new int[2];
					array[0] = x; 
					array[1] = y;
					queue.offer(array);
 
					while(!queue.isEmpty()) {
						array = queue.poll();
						int cx = array[0];
						int cy = array[1];
						for(int i=0; i<4; i++) {
							if(cx+dx[i] < 0 || cy+dy[i] < 0 || cx+dx[i] >= n || cy+dy[i] >= m) continue;
							if(map[cx+dx[i]][cy+dy[i]] == 1) {
								map[cx+dx[i]][cy+dy[i]] = 0;
								size++;
	
								array = new int[2];
								array[0] = cx+dx[i]; 
								array[1] = cy+dy[i];
								queue.offer(array);
							}
						}
						
					}
					if(size > max_size) {
						max_size = size;
					}
				}
			}
		}
		if(cnt != 0) System.out.println(cnt + "\n" + max_size);
		else System.out.println(0 + "\n" + 0);
		
	}
}
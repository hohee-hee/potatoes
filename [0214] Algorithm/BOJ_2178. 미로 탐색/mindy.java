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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		Queue<int[]> queue = new ArrayDeque<>();
		
		// map 만들기
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			for(int m=0; m<M; m++) {
				map[n][m] = Integer.parseInt(str.substring(m,m+1)); 
			}
		}
		
		for(int x=0; x<N; x++) {
			for(int y=0; y<M; y++) {
				if(map[x][y] >= 1) {
					int[] array = new int[2];
					array[0] = x; array[1] = y;
					queue.offer(array);
					
					while(!queue.isEmpty()) {
						array = queue.poll();
						int cx = array[0];
						int cy = array[1];
						for(int i=0; i<4; i++) {
							if(cx+dx[i] >= 0 && cx+dx[i] < N 
									&& cy+dy[i] >= 0 && cy+dy[i] < M
									&& map[cx+dx[i]][cy+dy[i]] == 1) {
								map[cx+dx[i]][cy+dy[i]] = map[cx][cy] + 1;
								int[] tmp = new int[2];
								tmp[0] = cx+dx[i]; tmp[1] = cy+dy[i];
								queue.offer(tmp);
								
								// 출력
//								for(int a=0; a<N; a++) {
//									for(int b=0; b<M; b++) {
//										System.out.printf("%3d ",map[a][b]);
//									}
//									
//									System.out.println();
//								}
//								System.out.println("----------------------");
							}
						}
					}
				}
				;
			}
		}
		//출력
		bw.write(map[N-1][M-1]+"\n");
		
		bw.close();
	}
}
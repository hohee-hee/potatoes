import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); sc.nextLine();
		int[][] arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str = sc.nextLine();
			for(int j=0; j<N; j++) 
				arr[i][j] = Integer.parseInt(str.substring(j, j+1));
		}
		
		int cnt = 0;
		int[] dx = { -1, 1, 0, 0 };
		int[] dy = { 0, 0, -1, 1 };
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		Queue<int[]> q = new ArrayDeque<>();
		for(int y=0; y<N; y++) {
			for(int x=0; x<N; x++) {
				if(arr[y][x] == 1) { // 한덩이 발견
					cnt++;
					int size = 1;
					
					arr[y][x] = 0;
					int[] tmp = { x, y };
					q.offer(tmp);
					while(!q.isEmpty()) { // 그 한덩이 처리
						int cx = q.peek()[0];
						int cy = q.poll()[1];
						for(int i=0; i<4; i++) {
							int nx = cx + dx[i];
							int ny = cy + dy[i];
							if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
							
							if(arr[ny][nx] == 1) {
								arr[ny][nx] = 0;
								size++;
								int[] ttmp = new int[2];
								ttmp[0] = nx;
								ttmp[1] = ny;
								q.offer(ttmp);
							}
						}
					}
					pq.offer(size);
				}
			}
		}
		System.out.println(cnt);
		while(!pq.isEmpty()) System.out.println(pq.poll());
	}
}


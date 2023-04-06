import java.util.Scanner;

public class Main {
	static boolean visited[];
	static int[][] arr ;
	static int N,M, cnt;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 정점의 갯수
		N = sc.nextInt();
		
		arr = new int[N][N];
		visited =  new boolean[N];
		
		M  = sc.nextInt();
		cnt = 0;
		
		// 1번 컴퓨터에 의해 감염되는 컴퓨터 수는?
		for(int i = 0; i<M; i++) {
				int x = sc.nextInt()-1;
				int y = sc.nextInt()-1;
				arr[x][y] = 1;
				arr[y][x] = 1;
			}
		
		
		// 1-1 = 0 번 컴퓨터에서 바이러스가 퍼질때
		// 즉 0번 컴퓨터랑 연결된 수는?
		//DFS 사용하는게 좋음
		DFS(0);
		System.out.println(cnt);
	}
	static void DFS(int V) {
		// 방문처리를 해준다.
		
		visited[V] = true;
		//System.out.println("연결고리 +" + (V+1));
		for(int i =0; i<N; i++) {
			
			if(arr[V][i] == 1 && !visited[i]) {
				cnt++;
				DFS(i);
			}
			
		}
		
		
	}

}
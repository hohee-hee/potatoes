import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int N, M, min;
	static int[][] arr;
	static int[][] chk;
	static ArrayList<int[]> al = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		N = sc.nextInt(); // y
		M = sc.nextInt(); // x
		arr = new int[N][M];
		chk = new int[N][M];
		min = Integer.MAX_VALUE;
		for(int y=0; y<N; y++) {
			for(int x=0; x<M; x++) {
				arr[y][x] = sc.nextInt();
				chk[y][x] = arr[y][x];
				if(1 <= arr[y][x] && arr[y][x] <= 5)
					al.add(new int[] {x, y, arr[y][x]});
			}
		}
		 bt(0);
		
		System.out.println(min);
	}
	
	static void bt(int n) {
		if(n == al.size()) { // 결과
			int tmp = 0;
			for(int y=0; y<N; y++) {
				for(int x=0; x<M; x++) {
					if(chk[y][x] == 0) tmp++;
					if(tmp >= min) return;
				}
			}
			if(tmp < min) min = tmp; 
			return;
		}
		
		int[] cc = al.get(n);
		if(cc[2] == 1) { // 카메라 종류
			for(int i=0; i<4; i++) {
				chker(cc, i, 1);
				bt(n+1);
				chker(cc, i, -1);
			}
		} 
		if(cc[2] == 2) {
			// 0 + 2 방향
			chker(cc, 0, 1);
			chker(cc, 2, 1);
			bt(n+1);
			chker(cc, 0, -1);
			chker(cc, 2, -1);
			// 1 + 3 방향
			chker(cc, 1, 1);
			chker(cc, 3, 1);
			bt(n+1);
			chker(cc, 1, -1);
			chker(cc, 3, -1);
		} 
		if(cc[2] == 3) {
			for(int i=0; i<4; i++) {
				chker(cc, i, 1);
				chker(cc, (i+1)%4, 1);
				bt(n+1);
				chker(cc, i, -1);
				chker(cc, (i+1)%4, -1);
			}
		} 
		if(cc[2] == 4) {
			for(int i=0; i<4; i++) {
				chker(cc, i, 1);
				chker(cc, (i+1)%4, 1);
				chker(cc, (i+2)%4, 1);
				bt(n+1);
				chker(cc, i, -1);
				chker(cc, (i+1)%4, -1);
				chker(cc, (i+2)%4, -1);
			}
		}
		if(cc[2] == 5) {
			for(int i=0; i<4; i++) chker(cc, i, 1);
			bt(n+1);
			for(int i=0; i<4; i++) chker(cc, i, -1);
		}
	}
	
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static void chker(int[] cc, int di, int m) { 
		int x = cc[0];
		int y = cc[1];
		int mv = 1;
		while(x+dx[di]*mv >= 0 && x+dx[di]*mv < M
				&& y+dy[di]*mv >= 0 && y+dy[di]*mv < N
				&& arr[y+dy[di]*mv][x+dx[di]*mv] != 6) {
			chk[y+dy[di]*mv][x+dx[di]*mv] += m;
			mv++;
		}
	}
}

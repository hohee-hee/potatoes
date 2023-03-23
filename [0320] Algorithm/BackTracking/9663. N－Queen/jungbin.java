package hw;

import java.util.Scanner;

public class P2806_nQueen {
	
	static int n, cnt;
	static boolean[][] map;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//test case 반복
		int t = sc.nextInt();
		for(int tc=1; tc<=t; tc++) {
			
			//배열 크기, 퀸 수 n
			n = sc.nextInt();
			map = new boolean[n][n]; 
			
			//총 경우의수
			cnt=0;
			cho(0);
			System.out.printf("#%d %d\n", tc, cnt);
			
			
		}
	}
	
	//자리 확인
	private static boolean ch(int x, int y) {
		//세로
		for(int i=0; i<n; i++) {
			if(map[i][y]) {
				return false;
			}
		}
		
		int a=0;
		//대각선1
		while(true) {
			if(x-a>=0 &&  y-a>=0) {
				if(map[x-a][y-a])
					return false;
			}
			if(x+a<n && y+a<n) {
				if(map[x+a][y+a]) {
					return false;
				}
			}
			a++;
			if(x-a<0 && y-a<0 && x+a>n && y+a>n)
				break;
		}
		
		a=0;
		//대각선2
		while(true) {
			if(x-a>=0 &&  y+a<n) {
				if(map[x-a][y+a])
					return false;
			}
			if(x+a<n && y-a>=0) {
				if(map[x+a][y-a]) {
					return false;
				}
			}
			a++;
			if(x-a<0 && y-a<0 && x+a>n && y+a>n)
				break;
		}
		
		return true;
	}
	
	
	//q 선택
	private static void cho(int k) {
		if(k==n) {
			cnt++;
			return;
		}
		
		for(int i=0; i<n; i++) {
			if(ch(k, i)) {
				map[k][i]=true;
				cho(k+1);
				map[k][i]=false;
			}
		}
	}

}

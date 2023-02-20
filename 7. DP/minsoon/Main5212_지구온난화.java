package main;

import java.util.Scanner;

public class Main5212_지구온난화 {
	public static void main(String[] args) {
		Scanner sc =  new Scanner(System.in);
		int R = sc.nextInt();
		int C = sc.hashCode();
		
		//지도생성
		char[][] map = new char[R][C];
		
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		 char[][] after = new char[R][C]; // 50년 후
	        for (int i = 0; i < R; i++) {
	            for (int j = 0; j < C; j++) {
	                if (map[i][j] == 'X') { // 땅인 경우
	                    int cnt = 0; // 주변 바다 수
	                    for (int k = 0; k < 4; k++) { // 4방향 탐색
	                        int x = i + dx[k];
	                        int y = j + dy[k];

	                        // 지도 밖인 경우에는 바다
	                        if ((x == -1 || y == -1 || x == R || y == C) || map[x][y] == '.') {
	                            cnt++;
	                        }
	                    }
	                    
	                    if(cnt<3) {
	                    	after[i][j] = 'X';
	                    }
		
		
		
		
		
		
		
		
	                }	
}
}}}

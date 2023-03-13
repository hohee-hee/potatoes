//지도 받는 것 부터 인덱스 오류...ㅜㅜ 뭐징... 잠만 다시 봄

package potato;

import java.util.Scanner;

public class P06_5212 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 int r = sc.nextInt();
		 int c = sc.nextInt();
		 
		 //지도
		 String s = sc.nextLine();
		 char[][] map = new char[r+2][c+2];
		 
		 for(int i=0; i<r; i++) {
			 for(int j=0; j<c; j++) {
				 map[i+1][j+1]= s.charAt(j);
			 }
		 }
		 
		 
		 int[]dx = {0, 0, 1, -1};
		 int[]dy = {1, -1, 0, 0};
		 
		 //섬 찾기
		 for(int i=0; i<r+2; i++) {
			 for(int j=0; j<c+2; j++) {
				 if(map[i][j]=='X') {
					 //삼면 바다 검사
					 int count =0;
					 for(int k=0; k<4; k++) {
						 if((i+dx[k]>0 && i+dx[k]<r+2) &&(j+dy[k]>0 && j+dy[k]<c+2)) {
							 if(map[i+dx[k]][j+dy[k]]=='.') {
								 count++;
							 }
						 //지도 밖
						 } else {
							 count++;
						 }
						 
					 }
					 if(count>=3) {
						 map[i][j]='.';
					 }
				 }
			 }
		 }
		 //바뀐 지도 출력
		 //지도에서 X표시가 있는 부분만 잘라서 출력해 주고 싶은데 뭔가 할 수 있을 것 같앙...
			    
			    sc.close();
		 
	}
}

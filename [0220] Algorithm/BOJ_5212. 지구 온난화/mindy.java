import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);		
		int R = sc.nextInt();
		int C = sc.nextInt();
		String[][] arr = new String[R+2][C+2];
		
		// padding 넣기
		for(int i=0; i<C+2; i++) { arr[0][i] = "."; arr[R+1][i] = "."; }
		for(int i=0; i<R+2; i++) { arr[i][0] = "."; arr[i][C+1] = "."; }
		// 입력
		for(int r=1; r<=R; r++) {
			String[] tmp = sc.next().split("");
			for(int c=1; c<=C; c++) arr[r][c] = tmp[c-1];
		}
		
		// 지도 업뎃 
		for(int i=1; i<R+1; i++) {
			for(int j=1; j<C+1; j++) {
				if(arr[i][j].equals("X")) {
					int cnt = 0;
					if(arr[i][j+1].equals(".")) cnt++;
					if(arr[i][j-1].equals(".")) cnt++;
					if(arr[i+1][j].equals(".")) cnt++;
					if(arr[i-1][j].equals(".")) cnt++;
					if(cnt >= 3) arr[i][j] = "O";
				}
			}
		}
		// for(int i=0; i<R+2; i++) System.out.println(Arrays.toString(arr[i])); // 출력
		
		// 지도 자르기, O -> . 로 바꾸기
		int minX = 11; int maxX = 0;
		int minY = 11; int maxY = 0;
		for(int i=1; i<R+1; i++) {
			for(int j=1; j<C+1; j++) {
				if(arr[i][j].equals("O")) arr[i][j] = ".";
				if(arr[i][j].equals("X")) {
					if(i < minY) minY = i;
					if(i > maxY) maxY = i;
					if(j < minX) minX = j;
					if(j > maxX) maxX = j;
				}
			}
		}
		
		for(int i=minY; i<=maxY; i++) {
			for(int j=minX; j<=maxX; j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}

	}
}

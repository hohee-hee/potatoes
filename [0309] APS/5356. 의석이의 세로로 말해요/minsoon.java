package pratice0220;

import java.util.Scanner;

public class Solution_5356의석이의세로로말해요 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//테스트 케이스 입력
		// 공백이 추가되어 값을 추가
		int T = sc.nextInt();sc.nextLine();
		for(int i =0; i< T; i++) {
			// 최대일 경우의 2차 배열을 생성
			System.out.print("#" + (i+1) + " ");
			String[][] arr = new String[5][15];
			//길이를 받아올 max값
			int max = 0;
			//엔터가 들어가면 다음 줄로 넘어가서 입력하고 싶은데
			for(int j=0; j<5; j++) {
				// 값을 받아와서 짜르기
				String[] str = sc.nextLine().split("");
				if(str.length > max) {
					max = str.length;
				}
				for(int k=0; k<str.length; k++) {
					arr[j][k] = str[k];
				}
			}
			// 값이 5 15 안에 들어가고 나머지 값은 null로 가득찬다.
			// 최댓값만큼 값을 불러와서 출력을 하지만 null값이 포함되어있다.
			for(int j=0; j<max; j++) {
		 
				for(int k=0; k<5; k++) {
					//그래서 null이 아닐때만 출ㅇ력
					if(arr[k][j] != null) {
					System.out.print(arr[k][j]);}

				}
			}
			System.out.println();
			
			
		}
		
		
		
	}
	}
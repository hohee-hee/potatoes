package day0406;

import java.util.Scanner;

public class Main_14891톱니바퀴 {

	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 각 톱니 // 앞이 톰니 번호, 뒤가 톱의 내용이 들어간다.
		arr = new int[5][8];

		for (int j = 1; j < 5; j++) {
			String num = sc.nextLine();
			for (int i = 0; i < 8; i++) {
				arr[j][i] = (num.charAt(i) - '0');
			}
		}
		

		// 회전수 입력
		int K = sc.nextInt();
		// 회전수를 받아오면 그 값을 가지고 바로 값을 체크해준다.
		for (int i = 0; i < K; i++) {
			int wheel = sc.nextInt();
			//System.out.println("바퀴는  : " + wheel);
			int spin = sc.nextInt();
			//System.out.println("도는 방향는  : " + spin);
			if (wheel == 1) { // 첫번째 값이 바뀌어야한다.
				spinning(spin, 1);
				spin *= -1;
				// 1이 돌면 2,3,4를 체크해줘야한다.
				if(arr[1][2] != arr[2][6]) { spinning(spin,2);
				spin *= -1;} else {continue;}
				if(arr[2][2] != arr[3][6]) { spinning(spin,3);
				spin *= -1;} else {continue;}
				if(arr[3][2] != arr[4][6]) { spinning(spin,4);}
				
				
			}else if(wheel == 2) {
				spinning(spin, 2);
				spin *= -1; 
				//1,3,4을 체크 해줘야한다.
				if(arr[2][6] != arr[1][2]) {spinning(spin,1);}

				if(arr[2][2] != arr[3][6]) {spinning(spin,3);
				spin *= -1;} else {continue;}
				if(arr[3][2] != arr[4][6]) {spinning(spin,4);}
				
				
			}else if(wheel == 3) {
				spinning(spin, 3);
				spin *= -1;
				
				// 2 1 4  지만 각자 독립 시행, 
				if(arr[3][2] != arr[4][6]) {spinning(spin,4);}
				
				if(arr[2][2] != arr[3][6]) {spinning(spin,2);
				spin *= -1; }else { continue;}
				if(arr[1][2] != arr[2][6]) {spinning(spin,1);
				
			}else if(wheel == 4) {
				spinning(spin, 4);
				spin *= -1;
				//3,2,1
				if(arr[4][6] != arr[3][2]) {spinning(spin,3);
				spin *= -1;} else {continue;}
				if(arr[3][6] != arr[2][2]) {spinning(spin,2);
				spin *= -1;} else {continue;}
				if(arr[2][6] != arr[1][2]) {spinning(spin,1);}
				
		}
			
	}
		}
		
					
		//점수확인
		int ans = 0;
		for(int i1=1; i1<5; i1++) {
			if(arr[i1][0] == 1) ans += Math.pow(2, (i1-1));
				
			}
		
		System.out.println(ans);


	}

	// 회전을 시키는 값을 가져온다.
	static void spinning(int spin, int wheel) {
		if (spin == 1) { // 시계방향으로 돌린다.
			//System.out.println("시계 방향입니다");
			int x = arr[wheel][7];
			for (int i = 7; i >= 1; i--) {
				arr[wheel][i] = arr[wheel][i-1];
			}
			arr[wheel][0] = x;
			
		} else if (spin == -1) { // 반시계 방향으로 돌린다.
			//System.out.println("시계  반대 방향입니다");
			int x = arr[wheel][0];
			for (int i = 0; i < 7; i++) {
				arr[wheel][i] = arr[wheel][i + 1];
			}
			arr[wheel][7] = x;
		}
	}

}

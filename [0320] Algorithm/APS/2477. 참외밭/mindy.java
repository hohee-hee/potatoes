import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		
		int num = sc.nextInt(); // 참외 개수
		int in = 6;
		int[][] arr = new int[5][2]; // 0 -> 세로 / 1 -> 가로 
		int _1 = 0, _2 = 0, _3 = 0, _4 = 0;
		while(in-- > 0) {
			int tmp = sc.nextInt();
			if(tmp == 1) {
				if(arr[1][0] != 0) {
					if(_1 - in > 3) { 
						arr[1][1] = arr[1][0]; 
						arr[1][0] = sc.nextInt(); 
					} else arr[1][1] = sc.nextInt();
				} else { arr[1][0] = sc.nextInt(); _1 = in;}
			}
			if(tmp == 2) {
				if(arr[2][0] != 0) {
					if(_2 - in > 3) { 
						arr[2][1] = arr[2][0]; 
						arr[2][0] = sc.nextInt(); 
					} else arr[2][1] = sc.nextInt();
				} else { arr[2][0] = sc.nextInt(); _2 = in; }
			}
			if(tmp == 3) {
				if(arr[3][0] != 0) {
					if(_3 - in > 3) { 
						arr[3][1] = arr[3][0]; 
						arr[3][0] = sc.nextInt(); 
					} else arr[3][1] = sc.nextInt();
				} else { arr[3][0] = sc.nextInt(); _3 = in; }
			}
			if(tmp == 4) {
				if(arr[4][0] != 0) {
					if(_4 - in > 3) { 
						arr[4][1] = arr[4][0]; 
						arr[4][0] = sc.nextInt(); 
					} else arr[4][1] = sc.nextInt();
				} else { arr[4][0] = sc.nextInt(); _4 = in; }
			}
		}
		
		String type = "";
		if(arr[1][1] != 0) type += "1";
		if(arr[2][1] != 0) type += "2";
		if(arr[3][1] != 0) type += "3";
		if(arr[4][1] != 0) type += "4";
		
		if(type.equals("13")) 
			ans = arr[2][0] * arr[4][0] - arr[1][0] * arr[3][1];
		else if (type.equals("14"))
			ans = arr[2][0] * arr[3][0] - arr[1][1] * arr[4][0];
		else if (type.equals("23"))
			ans = arr[1][0] * arr[4][0] - arr[2][1] * arr[3][0];
		else if (type.equals("24"))
			ans = arr[1][0] * arr[3][0] - arr[2][0] * arr[4][1];
		
		System.out.println(ans*num);
	}
}
// 백준 2477
/* 1 -> 60 100
 * 2 -> 160
 * 3 -> 30 20
 * 4 -> 50
 * 
 * 1 -> 60 100
 * 2 -> 160
 * 3 -> 50
 * 4 -> 20 30
 * 
 * 1 -> 160 
 * 2 -> 100 60
 * 3 -> 30 20
 * 4 -> 50
 * 
 * 6800
 */

import java.util.Scanner;

public class Main {
	static int[][] topni = new int[5][8];
	static int[] st = new int[5]; // 시작부분의 포인터 저장
	static boolean[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		for(int i=1; i<5; i++) {
			String tmp = sc.nextLine();
			for(int j=0; j<8; j++) 
				topni[i][j] = Integer.parseInt(tmp.substring(j, j+1));
		}
		int mv = sc.nextInt();
		while(mv-- > 0) {
			chk = new boolean[5];
			rotate(sc.nextInt(), sc.nextInt());
		}
		System.out.println(score());
	}
	
	static void rotate(int n, int di) {
		chk[n] = true; // 자기자신 방문 처리
		// 본인 오른쪽 확인 : 존재?, 방문?, 극 다름?
		if(n+1 < 5 && !chk[n+1] && (right(n) != left(n+1))) 
			rotate(n+1, op(di));
		// 본인 왼쪽 확인 : // 
		if(n-1 > 0 && !chk[n-1] && (right(n-1) != left(n))) 
			rotate(n-1, op(di));
		st[n] = (8+st[n]+-di)%8; // 본인 회전
	}
	static int op(int di) {
		return (di == 1)? -1 : 1;
	}
	static int right(int num) {
		return topni[num][(st[num]+2)%8];
	}
	static int left(int num) {
		return topni[num][(st[num]+6)%8];
	}
	static int score() {
		int sc = 0;
		for(int i=1; i<5; i++) {
			sc += (topni[i][st[i]] == 1)? (int)Math.pow(2, i-1): 0;
		}
		return sc;
	}
}

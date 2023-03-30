import java.util.Scanner;

public class Main {
	static int N, max;
	static int[][] eggs;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt(); // 계란 수
		eggs = new int[N][2];
		max = 0;
		for(int i=0; i<N; i++) { 
			eggs[i][0] = sc.nextInt(); // 내구도
			eggs[i][1] = sc.nextInt(); // 무게
		}
		
		bt(0);
		System.out.println(max);
	}
	
	static void bt(int k) { // k가 현재 든 계란 위치
		if(k == N) {
			int tmp = 0;
			for(int i=0; i<N; i++) { if(eggs[i][0] <= 0) tmp++; }
			if(tmp > max) max = tmp;
			return;
		}
		
		boolean chk = false;
		if(eggs[k][0] > 0) { // 손에 있는게 깨지지 않았을 때
			for(int i=0; i<N; i++) { // i가 표적 계란
				if(i != k && eggs[i][0] > 0) {
					chk = true;
					eggs[i][0] -= eggs[k][1]; // 깎고
					eggs[k][0] -= eggs[i][1];
					bt(k+1);
					eggs[i][0] += eggs[k][1]; // 복구
					eggs[k][0] += eggs[i][1];
				}
			}			
		}
		if(!chk) bt(k+1); 
	}
}
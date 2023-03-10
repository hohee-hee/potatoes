import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 학생 수
		int K = sc.nextInt(); // 최대 수 
		
		int[][] arr = new int[7][2];
		
		while(N-- > 0) {
			int S = sc.nextInt();
			int Y = sc.nextInt();
			arr[Y][S]++;
		}
		int ans = 0;
		for(int i=0; i<=6; i++) {
			for(int j=0; j<2; j++) {
				ans += arr[i][j]/K + (arr[i][j]%K != 0? 1:0);
			}
		}
		System.out.println(ans);
	}
}
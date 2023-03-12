import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[100][100];
		
		int pap = sc.nextInt();
		while(pap-- > 0) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			for(int i=0; i<10; i++) {
				for(int j=0; j<10; j++) arr[y+i][x+j]++;
			}
		}
		
		int ans = 0;
		for(int i=0; i<100; i++) {
			for(int j=0; j<100; j++)
				if(arr[i][j] > 0) ans++;
		}
		
		System.out.println(ans);
	}
}


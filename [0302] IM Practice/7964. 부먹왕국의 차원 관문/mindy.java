import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt();
		
		for(int t=1; t<=tests; t++) {
			int ans = 0;
			int city = sc.nextInt(), limit = sc.nextInt();
			
			int[] arr = new int[city+2];
			arr[0] = 1; arr[city+1] = 1;
			for(int i=1; i<=city; i++) arr[i] = sc.nextInt();
			
			for(int i=0; i<city+2; i++) {
				if(arr[i] == 1) {
					int chk = -1;
					for(int j=1; j<=limit; j++) {
						if(i+j > city+1 || arr[i+j] == 1) { i += j-1; chk = 1; break; }
					}
					if(chk == -1) {
						ans++;
						arr[i+limit] = 1;
					}
				}
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}


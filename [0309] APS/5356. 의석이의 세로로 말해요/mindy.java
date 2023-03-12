import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt(); sc.nextLine();
		
		for(int t=1; t<=tests; t++) {
			String ans = "";
			String[][] arr = new String[15][15];
			
			for(int i=0; i<5; i++) {
				char[] tmp = sc.nextLine().toCharArray();
				for(int j=0; j<tmp.length; j++)
					arr[i][j] = Character.toString(tmp[j]);
			}
			
			for(int i=0; i<15; i++) {
				for(int j=0; j<5; j++)
					if(arr[j][i] != null) ans += arr[j][i];
			}
			System.out.println("#"+t+" "+ans);
		}
	}
}
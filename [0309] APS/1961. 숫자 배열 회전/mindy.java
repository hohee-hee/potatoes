import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tests = sc.nextInt(); 
		
		for(int t=1; t<=tests; t++) {
			String ans = "#"+t+" ";
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) arr[i][j] = sc.nextInt();
			}
			
			System.out.println(ans);
			
			for(int i=0; i<n; i++) {
				for(int j=n-1; j>=0; j--) {
					System.out.print(arr[j][i]);
				}
				System.out.print(" ");
				for(int j=n-1; j>=0; j--) {
					System.out.print(arr[n-i-1][j]);
				}
				System.out.print(" ");
				for(int j=0; j<n; j++) {
					System.out.print(arr[j][n-i-1]);
				}
				System.out.println();
			}
		}
	}
}

package hw;

import java.util.Scanner;

public class P2193_이친수 {
	 public static void main(String args[]) {
		 Scanner sc = new Scanner(System.in);
         int cnt = sc.nextInt();
         int[]d = new int[cnt+1];
         // d[n] = n자리 이친수.
         d[0] = 0;
         d[1] = 1;
         for (int i = 2; i <= cnt; i++){
             d[i] = d[i-1] + d[i-2];
         }
         System.out.println(d[cnt]);
 }
}

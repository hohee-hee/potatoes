import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long[N+1];
		arr[1] = 1;
		if(N>1) arr[2] = 1;
		for(int i=3; i<=N; i++) arr[i] = arr[i-1] + arr[i-2];
		System.out.println(arr[N]);
	}
}
/*
 * 1 -> 1 			1
 * 
 * 2 -> 1 0			1
 * 	
 * 3 -> 1 0 0		2
 *      1 0 1
 *      
 * 4 -> 1 0 0 0 	3
 *      1 0 0 1
 *      1 0 1 0
 * 
 * 5 -> 1 0 0 0 0	5
 * 		1 0 0 0 1
 *      1 0 0 1 0
 *      1 0 1 0 0
 *      1 0 1 0 1
 * 
 */
